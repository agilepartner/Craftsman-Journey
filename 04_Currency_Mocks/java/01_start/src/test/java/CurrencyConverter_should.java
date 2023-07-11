import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CurrencyConverter_should {
    @Test
    void fail() {
        CurrencyConverter converter = new CurrencyConverter(null);
        converter.convert("USD", "EUR", 100.0);
    }
}
