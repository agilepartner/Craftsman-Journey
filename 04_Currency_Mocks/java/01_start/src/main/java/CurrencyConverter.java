public class CurrencyConverter {

    private final ChangeRateService changeRates;

    public CurrencyConverter(ChangeRateService changeRates) {
        this.changeRates = changeRates;
    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        throw new UnsupportedOperationException("Unimplemented method");
    }
    
}
