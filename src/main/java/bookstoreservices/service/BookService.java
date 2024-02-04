package bookstoreservices.service;

import bookstoreservices.common.APIResponse;
import bookstoreservices.common.BadRequestException;
import bookstoreservices.common.Error;
import bookstoreservices.data.BookData;
import bookstoreservices.dto.AuthorDTO;
import bookstoreservices.dto.BookDTO;
import bookstoreservices.dto.BookQueryDslDTO;
import bookstoreservices.entity.Author;
import bookstoreservices.entity.Book;
import bookstoreservices.entity.BookAuthor;
import bookstoreservices.repo.BookAuthorRepository;
import bookstoreservices.repo.BookRepository;
import bookstoreservices.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
//Service endu koduthaale default ah oru object create aakidum so BookController la new endellaam poddu create panna thevalla
@Autowired
private BookRepository bookRepository;

@Autowired
private BookAuthorRepository bookAuthorRepository;

@Autowired
private BookValidator bookValidator;
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

        //validation
       List<Error> errors=bookValidator.validateCreateBookRequest(book);
        //if not success
        if(errors.size()>0){
            throw new BadRequestException("bad request",errors);
        }

        //if success
        return bookRepository.save(book);
    }

    //single resourse
    public Optional<BookDTO> getBookById(Long bookId, boolean authorData)
    {
        Optional<Book> book;
        List<BookAuthor> bookAuthors=null;

        book=bookRepository.findById(bookId);

        if(authorData){
            bookAuthors=bookAuthorRepository.findALLByBookId(bookId);
            //table ah irunthu eduthachchu(mapping table)
        }

        BookDTO bookDTO=new BookDTO();

        //set book details
        bookDTO.setId(book.get().getId());
        bookDTO.setName(book.get().getName());
        bookDTO.setDesc(book.get().getDesc());
        bookDTO.setYearOfPublication(book.get().getYearOfPublication());
        bookDTO.setBookType(book.get().getBookType());

        //get author details
        List<AuthorDTO> authorDTOList=new ArrayList<>();
        if(bookAuthors!=null)
        {
            for(BookAuthor bookAuthor:bookAuthors)
            {
                Author author=bookAuthor.getAuthor();

                AuthorDTO authorDTO=new AuthorDTO();

                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setGender(author.getGender());

                authorDTOList.add(authorDTO);
            }

            //set author details
            bookDTO.setAuthors(authorDTOList);
        }

        return Optional.of(bookDTO);

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
    public String deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);

        return "Deleted Successfully";
    }

    //raw query -get books
    public APIResponse getBooksByRawQuery(Set<Integer> yop) {
        APIResponse apiResponse=new APIResponse();
        //db call
        List<Book> BookList= bookRepository.findAllByYearOfPublicationIn(yop);
//
//       Map data=new HashMap();
//       data.put("books",BookList);
//       //object ah tharum

        //set data
        BookData bookData=new BookData();
        bookData.setBooks(BookList);

        //set api response
       apiResponse.setData(bookData);
        return apiResponse;
    }

    public APIResponse getCaughtException(Integer yop) {

        int result=100/yop;
        APIResponse response=new APIResponse();
        response.setData(result);
        return response;
    }

    public APIResponse getBooksByQueryDsl(Integer year) {
        APIResponse apiResponse=new APIResponse();
        //repo to get the result
//       List<Book>bookList= bookRepository.getAllBooksByQueryDsl(year);
//       apiResponse.setData(bookList);

       List<BookQueryDslDTO> bookQueryDslDTOS=bookRepository.getAllBooksByQueryDslDto(year);
        apiResponse.setData(bookQueryDslDTOS);
        //return
        return apiResponse;
    }
    //50 varai irukku
}
