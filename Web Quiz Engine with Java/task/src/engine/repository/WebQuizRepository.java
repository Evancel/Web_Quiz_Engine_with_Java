package engine.repository;

import engine.entity.AppUser;
import engine.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebQuizRepository extends CrudRepository<Quiz, Integer>, PagingAndSortingRepository<Quiz, Integer> {
    Optional<Quiz> findByIdAndAuthor(int id, AppUser author);

    Iterable<Quiz> findByAuthor(AppUser author);

    @Override
    Page<Quiz> findAll(Pageable pageable);
}
