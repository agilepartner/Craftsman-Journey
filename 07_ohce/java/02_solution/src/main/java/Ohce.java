public class Ohce {
    public static final String BONITA_PALABRA = "¡Bonita palabra!";
    public static final String STOP = "Stop!";
    public static final String ADIOS = "Adios ";

    private final Console console;
    private final Clock clock;
    private String name;
    private CancellationToken token;

    public Ohce(Console console, Clock clock) {
        this.console = console;
        this.clock = clock;
        this.token = new CancellationToken();
    }

    public CancellationToken start(String name) {
        this.name = name;
        TimeOfDay time = clock.getTimeOfDay();
        console.printLine(String.format(time.pattern(), name));
        return token;
    }

    public void send(String message) {
        if (STOP.equals(message)) {
            console.printLine(ADIOS + name);
            token.cancel();
            return;
        }
        String reverted = new StringBuilder(message).reverse().toString();
        console.printLine(reverted);
        if (message.equals(reverted))
            console.printLine(BONITA_PALABRA);
    }
}
