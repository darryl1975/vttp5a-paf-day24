package sg.edu.nus.iss.vttp5a_paf_day24.model.exception;

public class AccountNotFoundException extends RuntimeException {
    
    public AccountNotFoundException() {

    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
