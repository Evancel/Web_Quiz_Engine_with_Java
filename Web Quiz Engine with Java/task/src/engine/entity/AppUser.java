package engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@JsonPropertyOrder({
        "id",
        "email",
})
public class AppUser {
    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @Email(regexp = ".+@.+\\..+", message = "Email must be valid and contain a domain")
    @Column(unique = true)
    private String email;
    @Size(min = 5)
    private String password;
    private String authority;
    @OneToMany(mappedBy = "appUser")
    private List<CompletedQuiz> completedQuizzes;

    public AppUser() {
    }

    public AppUser(String email, String password, String authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String role) {
        this.authority = role;
    }

    public List<CompletedQuiz> getCompletedQuizzes() {
        return completedQuizzes;
    }

    public void setCompletedQuizzes(List<CompletedQuiz> completedQuizzes) {
        this.completedQuizzes = completedQuizzes;
    }
}

