package bookstoreservices.repo;

import bookstoreservices.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {

    Page<Author> findAllByOrderByIdDesc(Pageable pageable);
}
