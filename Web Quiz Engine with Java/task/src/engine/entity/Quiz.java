package engine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Arrays;
import java.util.List;

@Entity
@JsonPropertyOrder({
        "id",
        "title",
        "text",
        "options",
})
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    @Fetch(value = FetchMode.SUBSELECT)
    @NotNull
    @Size(min = 2)
    private String[] options;
    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer = new int[0];
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private AppUser author;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompletedQuiz> completions;

    public Quiz() {
    }

    public Quiz(String title, String text, String[] options, AppUser author) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.author = author;
    }

    public Quiz(String title, String text, String[] options, int[] answer, AppUser author) {
        this.title = title;
        this.text = text;
        this.options = options;
        if (answer != null) {
            this.answer = answer;
        }
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        if (answer != null) {
            this.answer = answer;
        }
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setAuthor(AppUser user) {
        this.author = user;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}
