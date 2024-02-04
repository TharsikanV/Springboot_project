package bookstoreservices.repo;

import bookstoreservices.dto.BookQueryDslDTO;
import bookstoreservices.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {

    public List<Book> getAllBooksByQueryDsl(Integer year);
    public List<BookQueryDslDTO> getAllBooksByQueryDslDto(Integer year);

}
