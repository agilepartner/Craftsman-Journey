import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CancellationTokenShould {
    @Test
    void be_false_by_default() {
        CancellationToken token = new CancellationToken();
        assertThat(token.isCancelled()).isEqualTo(false);
    }

    @Test
    void be_true_after_being_cancelled(){
        CancellationToken token = new CancellationToken();
        token.cancel();
        assertThat(token.isCancelled()).isEqualTo(true);
    }
}
