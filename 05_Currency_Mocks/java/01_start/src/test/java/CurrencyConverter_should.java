import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyConverter_should {
    @Mock
    ExchangeRateService rates;

    @Test
    void fail() {
        CurrencyConverter converter = new CurrencyConverter(rates);
        converter.convert("USD", "EUR", 100.0);
    }
}
