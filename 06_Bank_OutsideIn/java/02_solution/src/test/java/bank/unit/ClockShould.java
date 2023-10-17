package bank.unit;

import bank.Clock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClockShould {

    @Test
    public void return_date_in_dd_MM_yyyy_format() {
        Clock clock = new TestableClock();
        String date = clock.todayAsString();
        assertEquals("14/07/2023", date);
    }

    private class TestableClock extends Clock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2023, 07, 14);
        }
    }
}