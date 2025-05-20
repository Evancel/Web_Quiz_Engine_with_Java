package engine.auth;

import engine.entity.AppUser;
import engine.repository.AppUserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class AuthenticationController {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping()
    public ResponseEntity<?> register(@Valid @RequestBody AppUser request) {
        if (userRepository.findAppUserByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        AppUser user = new AppUser(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                "ROLE_USER"
        );
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
