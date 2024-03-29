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
        ohce.start("Pedro");
        verify(console).printLine("¡Buenas noches Pedro!");
    }

    @Test
    void greet_you_with_buenos_dias_between_6_and_12() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.MORNING);
        ohce.start("Rosa");
        verify(console).printLine("¡Buenos días Rosa!");
    }

    @Test
    void greet_you_with_buenas_tardes_between_12_and_20() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.AFTERNOON);
        ohce.start("Paco");
        verify(console).printLine("¡Buenas tardes Paco!");
    }

    @Test
    void revert_a_word_sent() {
        ohce.send("hola");
        verify(console).printLine("aloh");
    }

    @Test
    void celebrate_when_a_palindrome_is_sent() {
        ohce.send("oto");
        verify(console).printLine("oto");
        verify(console).printLine("¡Bonita palabra!");
    }

    @Test
    void say_goodbye_when_stop_keyword_is_sent() {
        given(clock.getTimeOfDay()).willReturn(TimeOfDay.AFTERNOON);
        ohce.start("Pedro");
        ohce.send("Stop!");
        verify(console).printLine("¡Buenas tardes Pedro!");
        verify(console).printLine("Adios Pedro");
    }
}


