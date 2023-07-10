import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

class fizzbuzz_should {

    private FizzBuzz fizzbuzz;

    @BeforeEach
    public void init() {
        fizzbuzz = new FizzBuzz();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22, 23, 26, 28, 29 })
    public void return_the_number(Integer value) {
        String expected = value.toString();
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 24, 27, 33, 36, 39, 42, 48, 51, 54, 57, 63, 66, 69, 72, 78, 81, 84, 87, 93, 96, 99})
    public void return_fizz_for_multiples_of_3(Integer value) {
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(FizzBuzz.FIZZ, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35, 40, 50, 55, 65, 70, 80, 85, 95, 100})
    public void return_buzz_for_multiples_of_5(Integer value) {
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(FizzBuzz.BUZZ, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75, 90})
    public void return_fizzbuzz_for_multiples_of_3_and_5(Integer value) {
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(FizzBuzz.FIZZBUZZ, actual);
    }
}
