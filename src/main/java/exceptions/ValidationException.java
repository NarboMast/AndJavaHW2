package exceptions;

//it extends RuntimeException because it catches unchecked exceptions
public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);
    }
}
