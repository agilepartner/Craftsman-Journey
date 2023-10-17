import java.time.LocalDateTime;
public class Edible {
    private LocalDateTime expirationDate;
    private boolean approvedForConsumption;

    private Integer inspectorId;

    public boolean isEdible() {
        if (LocalDateTime.now().isBefore(this.expirationDate) && this.approvedForConsumption == true && this.inspectorId != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
