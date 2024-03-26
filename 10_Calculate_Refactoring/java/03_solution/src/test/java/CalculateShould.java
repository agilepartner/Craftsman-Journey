import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class CalculateShould {
    @ParameterizedTest
    @MethodSource("passingExamples")
    void verify_all_these_cases(double amount, int type, int years, double expected) {
        double actual = Calculate.calculate(amount, type, years);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> passingExamples() {
        return Stream.of(
                // NotRegistered
                of(100, 1, 3, 100),
                of(100, 1, 5, 100),
                of(100, 1, 10, 100),
                // SimpleCustomer
                of(100, 2, 3, 87.3),
                of(100, 2, 5, 85.5),
                of(100, 2, 10, 85.5),
                // ValuableCustomer
                of(100, 3, 3, 67.9),
                of(100, 3, 5, 66.5),
                of(100, 3, 10, 66.5),
                // MostValuableCustomer
                of(100, 4, 3, 48.5),
                of(100, 4, 5, 47.5),
                of(100, 4, 10, 47.5)
        );
    }

}
