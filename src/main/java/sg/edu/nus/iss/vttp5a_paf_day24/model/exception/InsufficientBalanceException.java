package sg.edu.nus.iss.vttp5a_paf_day24.model.exception;

public class InsufficientBalanceException extends RuntimeException {
    
    public InsufficientBalanceException() {

    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
