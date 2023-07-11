import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CurrencyConverter_should {
    @Test
    void fail_when_no_exchange_rate_service_is_injected() {
        assertThrows(UnsupportedOperationException.class,
                () -> new CurrencyConverter(null),
                "No exchange rate service was specified");
    }

    @Test
    void succeed_to_convert_when_exchange_rate_is_found() {
        // Arrange
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);
        when(rates.getRate(Currency.USD, Currency.EUR)).thenReturn(0.9);

        // Act
        Double actual = converter.convert(Currency.USD, Currency.EUR, 100.0);

        //Assert
        assertEquals(90.0, actual);
        verify(rates).getRate(Currency.USD, Currency.EUR);
    }

    @Test
    void fails_when_exchange_rate_is_not_found() {
        // Arrange
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);
        when(rates.getRate(Currency.USD, Currency.EUR))
                .thenThrow(new ExchangeRateNotFoundException(Currency.USD, Currency.EUR, "Rate not found"));

        assertThrows(ExchangeRateNotFoundException.class,
                () -> converter.convert(Currency.USD, Currency.EUR, 100.0));
    }

    @Test
    void fails_when_from_currency_is_null() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(null, Currency.EUR, 100.0));
    }

    @Test
    void fails_when_from_currency_is_empty() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert("", Currency.EUR, 100.0));
    }

    @Test
    void fails_when_to_currency_is_null() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, null, 100.0));
    }

    @Test
    void fails_when_to_currency_is_empty() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, "",100.0));
    }

    @Test
    void fails_when_amount_is_negative() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, Currency.EUR,-20.0));
    }

    @Test
    void fails_when_amount_is_zero() {
        ExchangeRateService rates = mock(ExchangeRateService.class);
        CurrencyConverter converter = new CurrencyConverter(rates);

        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(Currency.USD, Currency.EUR,0.0));
    }
}
