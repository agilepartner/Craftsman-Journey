public class CancellationToken {

    private boolean isCancelled = false;

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        isCancelled = true;
    }
}
