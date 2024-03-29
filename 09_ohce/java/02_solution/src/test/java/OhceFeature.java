import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CancellationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class OhceFeature {
    @Mock
    Console console;
    @Mock Clock clock;
    @Mock
    CancellationToken token;
    private Ohce ohce;

    @BeforeEach
    void init() {
        ohce = new Ohce(console, clock);
    }

    @Test
    void should_be_polite_and_write_in_console_until_stopped() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.AFTERNOON);
        CancellationToken token = ohce.start("Pedro");
        ohce.send("hola");
        ohce.send("oto");
        ohce.send("stop");
        ohce.send("Stop!");

        assertThat(token.isCancelled()).isEqualTo(true);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("¡Buenas tardes Pedro!");
        inOrder.verify(console).printLine("aloh");
        inOrder.verify(console).printLine("oto");
        inOrder.verify(console).printLine("¡Bonita palabra!");
        inOrder.verify(console).printLine("pots");
        inOrder.verify(console).printLine("Adios Pedro");
    }
}
