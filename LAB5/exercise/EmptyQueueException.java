package LAB5.exercise;
/** A class of runtime exceptions thrown when an attempt is made
 to access or remove the front of a queue. @author Frank M. Carrano
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        this(null);
    } // end default

    public EmptyQueueException(String message) {
        super(message);
    } // end constructor

} // end EmptyQueueException