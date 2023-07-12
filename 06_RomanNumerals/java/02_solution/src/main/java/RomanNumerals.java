import java.util.Comparator;
import java.util.TreeMap;

public class RomanNumerals {
    private static final TreeMap<Integer, String> decimalToRoman =
            new TreeMap<>(Comparator.reverseOrder());

    static {
        decimalToRoman.put(1000, "M");
        decimalToRoman.put(900, "CM");
        decimalToRoman.put(500, "D");
        decimalToRoman.put(400, "CD");
        decimalToRoman.put(100, "C");
        decimalToRoman.put(90, "XC");
        decimalToRoman.put(50, "L");
        decimalToRoman.put(40, "XL");
        decimalToRoman.put(10, "X");
        decimalToRoman.put(9, "IX");
        decimalToRoman.put(5, "V");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(1, "I");
    }

    public String convert(int decimalNumber) {
        if (decimalNumber <= 0)
            return "";

        StringBuilder roman = new StringBuilder();
        int remainder = decimalNumber;

        for (Integer decimal : decimalToRoman.keySet()) {
            while (remainder >= decimal) {
                roman.append(decimalToRoman.get(decimal));
                remainder -= decimal;
            }
        }

        return roman.toString();
    }
}