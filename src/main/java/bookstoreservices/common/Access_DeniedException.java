package bookstoreservices.common;

public class Access_DeniedException extends RuntimeException{
    public Access_DeniedException(String message){
        super(message);
    }


}
