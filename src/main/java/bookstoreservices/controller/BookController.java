package bookstoreservices.controller;

import bookstoreservices.common.APIResponse;
import bookstoreservices.dto.BookDTO;
import bookstoreservices.entity.Book;
import bookstoreservices.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
//   @Autowired antha object spring context la irukkaanu paakum apd iruntha ithu reference variable ah add akidum

    //    @RequestMapping(value = "/books")// new controller ah anodate pannian
//    public List<Book> getBooks(@RequestParam(value="yearOfPublication",required = false) Integer yop)//condition vachi get panna *****
//    {
//        return bookService.getBooks(yop);
//    }
//    @RequestMapping(value = "/books")
//    public List<Book> getBooks(@RequestParam(value="yearOfPublications",required = false) Set<Integer> yop,@RequestParam(value="bookType",required = false) String bookType)//condition vachi get panna *****
//    {
//        return bookService.getBooks(yop,bookType);
//    }

    /////////////////////////vithu//////////////////
//    @Autowired
    @RequestMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(value="yearOfPublications",required = false) Set<Integer> yop,
                               @RequestParam(value="bookType",required = false) String bookType){

        return bookService.getBooks(yop,bookType);
    }
    /////////////////////////vithu//////////////////////////////

    @RequestMapping(value="/books",method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){//enka irunthu object create panniramnu solluthu

        return bookService.createBook(book);

    }

    @RequestMapping(value="/books/{id}")
    public Optional<BookDTO> getBookById(@PathVariable("id") Long bookId,
                               @RequestParam(value = "authorData",required = false) boolean authorData){ //@PathParam-/books?id=27
//mela path la ethaavathu oru variable "id" nnu iruntha atha bookId kku eduthukka solluran
        return bookService.getBookById(bookId,authorData);
    }

    @RequestMapping(value="/books",method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book incomingBook){
        return bookService.updateBook(incomingBook);
    }

    @RequestMapping(value = "/books/{bookId}",method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable Long bookId){
        return bookService.deleteBookById(bookId);
    }

    @GetMapping("/raw/books")//ipdyum seyyalaam  ithula method define pannathevalla
    public APIResponse getBooksByRawQuery(@RequestParam(value = "yop") Set<Integer> yop){
        return bookService.getBooksByRawQuery(yop);
    }

    @GetMapping("/caughtException")//ipdyum seyyalaam  ithula method define pannathevalla
    public APIResponse getCaughtException(@RequestParam(value = "number") Integer yop){
        return bookService.getCaughtException(yop);
    }


    @GetMapping("/queryDsl/books")
    public APIResponse getBooksByQueryDsl(@RequestParam(value = "year") Integer year){


        return bookService.getBooksByQueryDsl(year);
    }
}
