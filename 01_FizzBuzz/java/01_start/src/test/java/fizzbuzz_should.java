import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class fizzbuzz_should {

    @Test
    void fail() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String value = fizzbuzz.get(1); // Should fail
    }
}
