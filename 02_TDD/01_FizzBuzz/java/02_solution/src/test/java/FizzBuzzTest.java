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
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17})
    public void return_the_number(Integer value) {
        String expected = value.toString();
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 15, 18, 21})
    public void return_fizz_for_multiples_of_3(Integer value) {
        String actual = fizzbuzz.get(value);
        Assertions.assertEquals(FizzBuzz.FIZZ, actual);
    }

}
