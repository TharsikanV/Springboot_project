package bookstoreservices.repo;

import bookstoreservices.entity.Author;
import bookstoreservices.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAuthorRepository extends CrudRepository<BookAuthor,Long> {
    List<BookAuthor> findALLByBookId(Long bookId);
}
