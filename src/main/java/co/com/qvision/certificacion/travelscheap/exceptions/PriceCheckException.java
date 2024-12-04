package co.com.qvision.certificacion.travelscheap.exceptions;

public class PriceCheckException extends AssertionError {
    public static final String EXCEPTION_PRICE = "The total price isn´t correct";
    public PriceCheckException(String message, Throwable cause){
        super(message,cause);
    }
}
