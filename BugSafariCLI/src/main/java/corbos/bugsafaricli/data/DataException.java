package corbos.bugsafaricli.data;

public class DataException extends Exception {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Exception rootCause) {
        super(message, rootCause);
    }
}
