public class CurrencyConverter {

    private final ExchangeRateService changeRates;

    public CurrencyConverter(ExchangeRateService changeRates) {
        this.changeRates = changeRates;
    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        throw new UnsupportedOperationException("Unimplemented method");
    }
    
}
