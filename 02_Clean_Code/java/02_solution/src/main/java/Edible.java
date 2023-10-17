import java.time.LocalDateTime;
public class Edible {
    private LocalDateTime expirationDate;
    private boolean approvedForConsumption;

    private Integer inspectorId;

    public boolean isEdible() {
        return  (isFresh() && isApproved() && isInspected());
    }

    private boolean isInspected() {
        return this.inspectorId != null;
    }

    private boolean isApproved() {
        return this.approvedForConsumption;
    }

    private boolean isFresh() {
        return LocalDateTime.now().isBefore(this.expirationDate);
    }
}
