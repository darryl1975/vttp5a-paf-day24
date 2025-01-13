package sg.edu.nus.iss.vttp5a_paf_day24.model.exception;

public class AccountInactiveException extends RuntimeException {
    
    public AccountInactiveException() {

    }

    public AccountInactiveException(String message) {
        super(message);
    }

    public AccountInactiveException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
