public class Ohce {
    private final Console console;

    public Ohce(Console console) {
        this.console = console;
    }

    public void run(String name) {
        console.printLine(String.format("¡Buenas noches %s!", name));
    }
}
