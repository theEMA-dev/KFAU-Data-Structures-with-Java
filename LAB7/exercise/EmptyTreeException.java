package LAB7.exercise;

/**
 * Runtime exception thrown when one tries to access the root of an
 * empty tree.
 */

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        this(null);
    }
    public EmptyTreeException(String err) {
        super(err);
    }
}
