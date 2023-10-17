import java.time.LocalDateTime;
import java.util.List;

public class Text {

    public String getText(List<LocalDateTime> arrivals) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LocalDateTime arrival: arrivals) {
            String message = arrival.isAfter(LocalDateTime.now()) ? arrival.toString() : "Delayed";
            stringBuilder.append(message);
        }
        return stringBuilder.toString();
    }
}
