package bookstoreservices.validator;

import bookstoreservices.common.Error;
import bookstoreservices.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //intha anotation ah use panna @Autowired use pannalaam
public class BookValidator {

    public List<Error> validateCreateBookRequest(Book book) {

        List<Error> errors=new ArrayList<>();

        //name
        if(book.getName()==null){
            Error error=new Error("name","book name is null");
            errors.add(error);
        }
        //yop
        if(book.getYearOfPublication()==null){
            Error error=new Error("yop","yop is null");
            errors.add(error);
        }

        //book type
        if(book.getBookType()==null){
            Error error=new Error("bookType","bookType is null");
            errors.add(error);
        }
        return errors;
    }
}
