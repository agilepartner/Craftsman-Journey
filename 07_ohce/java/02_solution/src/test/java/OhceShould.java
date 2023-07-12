import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OhceShould {
    @Mock
    private Console console;
    @Mock
    private Clock clock;
    private Ohce ohce;

    @BeforeEach
    void init() {
        ohce = new Ohce(console, clock);
    }

    @Test
    void greet_you_with_buenas_noches_between_20_and_6() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.NIGHT);
        ohce.run("Pedro");
        verify(console).printLine("¡Buenas noches Pedro!");
    }
    @Test
    void greet_you_with_buenos_dias_between_6_and_12() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.MORNING);
        ohce.run("Rosa");
        verify(console).printLine("¡Buenos días Rosa!");
    }
}


