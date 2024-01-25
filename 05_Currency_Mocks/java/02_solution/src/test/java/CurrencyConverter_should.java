import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyConverter_should {
    @Mock
    ExchangeRateService rates;
    private CurrencyConverter converter;

    @BeforeEach
    public void init() {
        converter = new CurrencyConverter(rates);
    }

    @Test
    void fail_when_no_exchange_rate_service_is_injected() {
        assertThrows(UnsupportedOperationException.class,
                () -> new CurrencyConverter(null),
                "No exchange rate service was specified");
    }

    @Test
    void succeed_to_convert_when_exchange_rate_is_found() {
        // Arrange
        when(rates.getRate(Currency.USD, Currency.EUR)).thenReturn(0.9);

        // Act
        Double actual = converter.convert(Currency.USD, Currency.EUR, 100.0);

        //Assert
        assertEquals(90.0, actual);
        verify(rates).getRate(Currency.USD, Currency.EUR);
    }

    @Test
    void fail_when_exchange_rate_is_not_found() {
        // Arrange
        when(rates.getRate(Currency.USD, Currency.EUR))
                .thenThrow(new ExchangeRateNotFoundException(Currency.USD, Currency.EUR, "Rate not found"));

        assertThrows(ExchangeRateNotFoundException.class,
                () -> converter.convert(Currency.USD, Currency.EUR, 100.0));
    }

    @Test
    void fail_when_from_currency_is_null() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(null, Currency.EUR, 100.0));
    }

    @Test
    void fail_when_from_currency_is_empty() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert("", Currency.EUR, 100.0));
    }

    @Test
    void fail_when_to_currency_is_null() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, null, 100.0));
    }

    @Test
    void fail_when_to_currency_is_empty() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, "",100.0));
    }

    @Test
    void fail_when_amount_is_negative() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, Currency.EUR,-20.0));
    }

    @Test
    void fail_when_amount_is_zero() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, Currency.EUR,0.0));
    }
    @Test
    void fail_when_converted_amount_is_more_than_double_max_value() {
        when(rates.getRate(Currency.USD, Currency.EUR)).thenReturn(10.0);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, Currency.EUR,Double.MAX_VALUE));
    }
}
