package engine.service;

import engine.entity.AppUser;
import engine.entity.Quiz;
import engine.repository.CompletedQuizRepository;
import engine.repository.WebQuizRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class WebQuizService {
    private final WebQuizRepository repository;
    private final CompletedQuizRepository completedQuizRepository;

    public WebQuizService(WebQuizRepository repository, CompletedQuizRepository completedQuizRepository) {
        this.repository = repository;
        this.completedQuizRepository = completedQuizRepository;
    }

    public void addWebQuiz(Quiz quiz) {
        if (quiz == null) {
            return;
        }

        repository.save(quiz);
    }

    public Optional<Quiz> getQuizById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Quiz> getQuizByIdAndAuthor(Integer id, AppUser author) {
        return repository.findByIdAndAuthor(id, author);
    }

    public Iterable<Quiz> getQuizesByAuthor(AppUser author) {
        return repository.findByAuthor(author);
    }

    public Page<Quiz> getQuizes(Integer pageNumber, Integer pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id")));
    }

    public boolean rightAnswers(Integer id, int[] answer) {
        Quiz currQuiz = repository.findById(id).get();


        return Arrays.equals(currQuiz.getAnswer(), normalize(answer));
    }

    public static int[] normalize(int[] array) {
        return array == null ? new int[0] : array;
    }

    public void deleteQuiz(int id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
