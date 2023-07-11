package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String todayAsString() {
        return  today().format(FORMATTER);
    }

    protected LocalDate today() {
        return LocalDate.now();
    }

}
