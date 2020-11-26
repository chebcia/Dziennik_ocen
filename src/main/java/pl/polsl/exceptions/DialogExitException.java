package pl.polsl.exceptions;
/**
 * Dialog exit exception class create for exceptions
 * @author Natalia Cheba
 * @version 1.0
 */

public class DialogExitException extends Exception {

    /**
     *
     */
    public DialogExitException() {
    }
    
    /**
     *
     * @param message
     */
    public DialogExitException(String message) {
        super(message);
    }
}
