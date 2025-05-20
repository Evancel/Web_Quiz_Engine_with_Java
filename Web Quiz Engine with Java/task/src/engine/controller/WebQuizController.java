package engine.controller;

import engine.dto.AnswerDTO;
import engine.entity.AppUser;
import engine.entity.CompletedQuiz;
import engine.entity.Quiz;
import engine.entity.Result;
import engine.repository.AppUserRepository;
import engine.service.CompletedQuizService;
import engine.service.WebQuizService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class WebQuizController {
    private final WebQuizService webQuizService;
    private final AppUserRepository userRepository;
    private final CompletedQuizService completedQuizService;

    private final Integer pageSize = 10;

    public WebQuizController(WebQuizService webQuizService,
                             AppUserRepository userRepository,
                             CompletedQuizService completedQuizService) {
        this.webQuizService = webQuizService;
        this.userRepository = userRepository;
        this.completedQuizService = completedQuizService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWebQuiz(@PathVariable("id") Integer id) {
        Optional<Quiz> quiz = webQuizService.getQuizById(id);
        if (quiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(quiz);
    }

    @GetMapping()
    public ResponseEntity<?> getWebQuizes(@RequestParam("page") Integer pageNumber) {
        if (pageNumber < 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(webQuizService.getQuizes(pageNumber, pageSize));
    }

    @GetMapping("/completed")
    public ResponseEntity<?> getCompletedWebQuizes(@RequestParam("page") Integer pageNumber,
                                                   @AuthenticationPrincipal UserDetails details) {
        if (pageNumber < 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<AppUser> currUser = userRepository.findAppUserByEmail(details.getUsername());
        if (currUser.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(completedQuizService.getCompletedQuizByAppUser(
                currUser.get(),
                pageNumber,
                pageSize));
    }

    @PostMapping()
    public ResponseEntity<?> addWebQuiz(@AuthenticationPrincipal UserDetails details,
                                        @Valid @RequestBody Quiz quiz) {
        Optional<AppUser> author = userRepository.findAppUserByEmail(details.getUsername());
        if (author.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        quiz.setAuthor(author.get());

        webQuizService.addWebQuiz(quiz);
        return ResponseEntity.ok().body(quiz);
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<?> postAnswer(@AuthenticationPrincipal UserDetails details,
                                        @PathVariable("id") Integer id,
                                        @RequestBody AnswerDTO answerDTO) {
        Optional<Quiz> quiz = webQuizService.getQuizById(id);
        if (quiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<AppUser> currUser = userRepository.findAppUserByEmail(details.getUsername());
        if (currUser.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        Result result;
        if (webQuizService.rightAnswers(id, answerDTO.getAnswer())) {
            result = new Result(true, "Congratulations, you're right!");
            CompletedQuiz completedQuiz = new CompletedQuiz(currUser.get(), quiz.get(), LocalDateTime.now());
            completedQuizService.save(completedQuiz);
        } else {
            result = new Result(false, "Wrong answer! Please, try again.");
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuiz(@AuthenticationPrincipal UserDetails details,
                                        @PathVariable("id") Integer id) {
        Optional<AppUser> currUser = userRepository.findAppUserByEmail(details.getUsername());
        if (currUser.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
        AppUser author = currUser.get();

        Optional<Quiz> quiz = webQuizService.getQuizById(id);
        if (quiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (!quiz.get().getAuthor().equals(author)) {
            return ResponseEntity.status(403).build();
        }

        webQuizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
