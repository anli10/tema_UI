package utility;

public class AutomationException extends RuntimeException{

    public AutomationException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message + "Caused by: " + cause.getStackTrace().toString());
    }

    public AutomationException(String message) {
        super(message);
        System.out.println("Following error has occured: " + message);
    }

    public AutomationException(Throwable cause) {
        super(cause);
    }
}
