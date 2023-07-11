public class ExchangeRateNotFoundException extends RuntimeException {
    public final String From;
    public final String To;

    public ExchangeRateNotFoundException(String from, String to, String message) {
        super(message);
        From = from;
        To = to;
    }
}
