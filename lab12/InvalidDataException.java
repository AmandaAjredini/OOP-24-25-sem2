// Class which defines a custom exception type for handling invalid employee data
public class InvalidDataException extends Exception {
    // Constructor that accepts an error message and passes it to the superclass (Exception)
    public InvalidDataException(String message) {
        super(message);
    }
}
