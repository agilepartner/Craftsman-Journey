import java.time.LocalTime;

public class Clock {
    public static final LocalTime SIX_AM = LocalTime.of(6, 0, 0);
    public static final LocalTime NOON = LocalTime.of(12, 0, 0);
    public static final LocalTime HEIGHT_PM = LocalTime.of(20, 0, 0);
    public TimeOfDay getTimeOfDay() {
        LocalTime time = time();
        if (time.isAfter(SIX_AM) && time.isBefore(NOON))
            return TimeOfDay.MORNING;
        if (time.isAfter(NOON) && time.isBefore(HEIGHT_PM))
            return TimeOfDay.AFTERNOON;
        if (time.isAfter(HEIGHT_PM))
            return TimeOfDay.NIGHT;

        throw new UnsupportedOperationException("Cannot define time of day");
    }

    protected LocalTime time() {
        return LocalTime.now();
    }
}
