package sg.edu.nus.iss.vttp5a_paf_day24.model.exception;

public class BookNotFoundException extends RuntimeException {
    
    public BookNotFoundException() {

    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
