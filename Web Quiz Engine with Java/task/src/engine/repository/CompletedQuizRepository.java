package engine.repository;

import engine.entity.AppUser;
import engine.entity.CompletedQuiz;
import engine.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuizRepository extends CrudRepository<CompletedQuiz, Integer>,
        PagingAndSortingRepository<CompletedQuiz, Integer> {
    boolean existsByQuiz(Quiz quiz);

    void deleteByQuiz(Quiz quiz);

    Page<CompletedQuiz> findAllByAppUser(AppUser user, Pageable pageable);
}
