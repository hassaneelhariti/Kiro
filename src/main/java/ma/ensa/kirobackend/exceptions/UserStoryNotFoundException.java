package ma.ensa.kirobackend.exceptions;

public class UserStoryNotFoundException extends RuntimeException {
    public UserStoryNotFoundException(String message) {
        super(message);
    }
}