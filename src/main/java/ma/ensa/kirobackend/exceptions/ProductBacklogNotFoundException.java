package ma.ensa.kirobackend.exceptions;

public class ProductBacklogNotFoundException extends RuntimeException {
    public ProductBacklogNotFoundException(String message) {
        super(message);
    }
}