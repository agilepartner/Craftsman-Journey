public class FizzBuzz {
    public static final String FIZZ = "Fizz";    
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = FIZZ + BUZZ;
    
    public String get(Integer value) {
        if (isFizz(value) && isBuzz(value))
            return FIZZBUZZ;
        if (isFizz(value))
            return FIZZ;
        if (isBuzz(value))
            return BUZZ;
        return value.toString();
    }

    private boolean isFizz(Integer value) {
        return value % 3 == 0;
    }

    private boolean isBuzz(Integer value) {
        return value % 5 == 0;
    }

}
