import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FizzBuzzTest {

    @Test
    void fail() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String value = fizzbuzz.get(1);
        assertThat(value)
                .isEqualTo("1");
    }

    @Test
    void it_should_not_fail() {
        assertThat(42)
                .isEqualTo(42);
    }
}
