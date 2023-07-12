import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockShould {
    @Test
    public void return_morning_between_6_and_12() {
        Clock clock = new TestableClock(10);
        TimeOfDay timeOfDay = clock.getTimeOfDay();
        assertThat(timeOfDay).isEqualTo(TimeOfDay.MORNING);
    }
    @Test
    public void return_afternoon_between_12_and_20() {
        Clock clock = new TestableClock(14);
        TimeOfDay timeOfDay = clock.getTimeOfDay();
        assertThat(timeOfDay).isEqualTo(TimeOfDay.AFTERNOON);
    }

    @Test
    public void return_night_between_20_and_6() {
        Clock clock = new TestableClock(22);
        TimeOfDay timeOfDay = clock.getTimeOfDay();
        assertThat(timeOfDay).isEqualTo(TimeOfDay.NIGHT);
    }
    private class TestableClock extends Clock {

        private final int hours;

        public TestableClock(int hours) {
            this.hours = hours;
        }

        @Override
        protected LocalTime time() {
            return LocalTime.of(hours, 0, 0);
        }
    }
}
