import java.util.Scanner;

public class App {
    public static void main(@org.jetbrains.annotations.NotNull String[] args) {
        Console console = new Console();
        if (args.length == 0 || args[0].isEmpty()) {
            console.printLine("Usage: ohce <name>");
            return;
        }

        Ohce ohce = new Ohce(console, new Clock());
        CancellationToken token = ohce.start(args[0]);

        Scanner scanner = new Scanner(System.in);
        while(!token.isCancelled()) {
            String message = scanner.nextLine();
            ohce.send(message);
        }
    }
}
