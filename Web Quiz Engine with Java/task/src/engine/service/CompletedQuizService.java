package engine.service;

import engine.dto.CompletedQuizResponse;
import engine.entity.AppUser;
import engine.entity.CompletedQuiz;
import engine.repository.CompletedQuizRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompletedQuizService {
    private final CompletedQuizRepository completedQuizRepository;

    public CompletedQuizService(CompletedQuizRepository completedQuizRepository) {
        this.completedQuizRepository = completedQuizRepository;
    }

    public void save(CompletedQuiz completedQuiz) {
        completedQuizRepository.save(completedQuiz);
    }

    public Page<CompletedQuizResponse> getCompletedQuizByAppUser(AppUser user, Integer pageNumber, Integer pageSize) {
        return completedQuizRepository.findAllByAppUser(
                user,
                PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "completedAt"))
        ).map(cq -> new CompletedQuizResponse(cq.getQuiz().getId(), cq.getCompletedAt()));
    }
}
