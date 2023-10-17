import java.time.LocalDateTime;
import java.util.List;

public class Text {
    public String transform(List<LocalDateTime> s)
    {String d = null;
        for (LocalDateTime kc : s) // arrival times
        {if (kc.isAfter(LocalDateTime.now())) d = d + kc + "\n";
        else d = d + "Delayed\n";} // flight is delayed
    return d;}
}
