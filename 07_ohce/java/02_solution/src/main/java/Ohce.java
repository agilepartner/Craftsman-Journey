public class Ohce {
    public static final String BONITA_PALABRA = "¡Bonita palabra!";
    private final Console console;
    private final Clock clock;

    public Ohce(Console console, Clock clock) {
        this.console = console;
        this.clock = clock;
    }

    public void run(String name) {
        TimeOfDay time = clock.getTimeOfDay();
        console.printLine(String.format(time.pattern(), name));
    }

    public void send(String message) {
        String reverted = new StringBuilder(message).reverse().toString();
        console.printLine(reverted);
        if (message.equals(reverted))
            console.printLine(BONITA_PALABRA);
    }
}
