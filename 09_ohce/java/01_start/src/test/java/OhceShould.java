import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OhceShould {
    @Mock
    private Console console;
    private Ohce ohce;

    @BeforeEach
    void init() {
        ohce = new Ohce(console);
    }

    @Test
    void greet_you_with_buenas_noches_between_20_and_6() {
        ohce.run("Pedro");
        verify(console).printLine("¡Buenas noches Pedro!");
    }
}


