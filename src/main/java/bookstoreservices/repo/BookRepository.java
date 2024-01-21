package bookstoreservices.repo;

import bookstoreservices.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

//@Repository                                                 //Entity oda primary key(id) oda data type
//public interface BookRepository extends CrudRepository<Book,Integer> {
//   List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop,String bookType);
   //By-where   In-In    And-And
   //spring JPA Keywords:
   //find
   //exists
  //delete
   //count
   /////////////////////////////////public interface BookRepository extends JpaRepository<Book, Long> {
   //    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> years, String bookType);
   //}
   ////////////////////////////CrudRepository
   //Terminating
   //By
   //And

   //IN:
   //findAllByBookTypeIn(Set<String> bookTypes)

   //IgnoreCase:
   //List<Book> findAllByBookTypeIgnoreCaseIn(Set<String> bookTypes)

   //And:
   //List<Book> findAllByBookTypeIgnoreCaseInAndYearOfPublication(Set<String> bookTypes,Integer yop)

   //NotIn:
   //findAllByBookTypeIgnoreCaseNotIn(Set<String> bookTypes)

   //Exists:
   //boolean existsByBookType(String bookType)

   //Book findOneByBookType(Long bookId)

   //findAllBy vs findBy:
   //findByBookTypeIgnoreCaseIn(set<String> bookTypes)

   //Examples:
   //findOneByYearOfPublication
   //findOnlyOneByYearOfPublication
   //findAnythingByBookType
//}
//
////////////////////////vithu///////////////
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

   List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop,String bookType);
}