package ma.ensa.kirobackend.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String s) {
        super(s);
    }
}
