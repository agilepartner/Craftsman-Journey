public class Ohce {
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
}
