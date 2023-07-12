import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

public class RomanNumeralsShould {

    private RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    public void return_nothing_when_0() {
        String roman = romanNumerals.convert(0);
        assertThat(roman).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("passingExamples")
    public void return_roman_when_decimal_numeral(int decimalNumeral, String expectedRoman) {
        String roman = romanNumerals.convert(decimalNumeral);
        assertThat(roman).isEqualTo(expectedRoman);
    }

    private static Stream<Arguments> passingExamples() {
        return Stream.of(
                of(1, "I"),
                of(2, "II"),
                of(3, "III"),
                of(4, "IV"),
                of(5, "V"),
                of(6, "VI"),
                of(9, "IX"),
                of(10, "X"),
                of(14, "XIV"),
                of(21, "XXI"),
                of(42, "XLII"),
                of(50, "L"),
                of(58, "LVIII"),
                of(99, "XCIX"),
                of(100, "C"),
                of(101, "CI"),
                of(449, "CDXLIX"),
                of(500, "D"),
                of(2023, "MMXXIII"),
                of(2499, "MMCDXCIX")
        );
    }
}
