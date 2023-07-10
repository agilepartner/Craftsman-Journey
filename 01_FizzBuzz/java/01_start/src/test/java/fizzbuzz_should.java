import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class fizzbuzz_should {

    @Test
    void fail() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String value = fizzbuzz.get(1); // Should fail
    }
}
