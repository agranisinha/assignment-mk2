package towersim.util;

/**
 * Exception thrown when there is insufficient space to undertake an action.
 *
 * @author tli14
 */
public class NoSpaceException extends Exception {
    /**
     * Constructs a NoSpaceException with no detail message.
     */
    public NoSpaceException() {
        super();
    }

    /**
     * Constructs a NoSpaceException that contains a helpful detail message explaining why the exception occurred.
     *
     * @param errorMessage detail message
     */
    public NoSpaceException(String errorMessage) {
        super(errorMessage);
    }
}
