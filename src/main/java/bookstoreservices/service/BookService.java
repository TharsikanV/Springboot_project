package bookstoreservices.service;

import bookstoreservices.entity.Book;
import bookstoreservices.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
//Service endu koduthaale default ah oru object create aakidum so BookController la new endellaam poddu create panna thevalla
@Autowired
private BookRepository bookRepository;
//   Get
//    public List<Book> getBooks(Set<Integer> yop,String bookType){
//
//        List<Book> bookList=new ArrayList<>();
//        //databasela irunthu eduththatha ithula store pannaporam
//        if(yop==null){
//            bookRepository.findAll().forEach(book -> bookList.add(book));
//            //bookRepository object moolama eduththatha bookList ka add panniram
//        }
//        else {
//            return bookRepository.findAllByYearOfPublicationInAndBookType(yop,bookType);
//        }
//
//
//
//        return bookList;
//    }
    ///////////////////////////////////vithu////////////////////////////
public List<Book> getBooks(Set<Integer> yop,String bookType){
    List<Book> bookList=new ArrayList<>();
    if(yop==null){
        bookRepository.findAll().forEach(book -> bookList.add(book));

    }
    else {
        return bookRepository.findAllByYearOfPublicationInAndBookType(yop,bookType);
    }
    return bookList;
}
//////////////////////vithu/////////////////////////

    //Create
    public Book createBook(Book book){

        return bookRepository.save(book);
    }

    //single resourse
    public Optional<Book> getBookById(Integer bookId)
    {
        return bookRepository.findById(bookId);
    }
//    public Book getBookById(Integer bookid) {
//        Optional<Book> optionalBook = bookRepository.findById(bookid);
//        return optionalBook.orElse(null);
//    }
    //update
    public Book updateBook(Book incomingBook) {
        return bookRepository.save(incomingBook);
    }

    //delete
    public String deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);

        return "Deleted Successfully";
    }

    //raw query -get books
    public List<Book> getBooksByRawQuery(Set<Integer> yop) {
       List<Book> BookList= bookRepository.findAllByYearOfPublicationIn(yop);
        return BookList;
    }
}
