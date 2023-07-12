import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsShould {

    private RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    public void return_nothing_when_0() {
        String actual = romanNumerals.convert(0);
        assertThat(actual).isEqualTo("");
    }
}
