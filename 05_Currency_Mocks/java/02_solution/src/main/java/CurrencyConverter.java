public class CurrencyConverter {

    private final ExchangeRateService rates;

    public CurrencyConverter(ExchangeRateService rates) {
        if (rates == null)
            throw new UnsupportedOperationException("No exchange rate service was specified");
        this.rates = rates;
    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        checkCurrency(fromCurrency, "From");
        checkCurrency(toCurrency, "To");
        checkAmout(amount);

        Double rate = rates.getRate(fromCurrency, toCurrency);
        checkRate(rate);

        checkConvertedAmount(amount, rate);

        return rate * amount;
    }

    private void checkCurrency(String currency, String name) {
        if (currency == null || currency.trim().isEmpty())
            throw new IllegalArgumentException("No '"+ name +"' currency specified");
    }

    private void checkAmout(Double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount should be positive");
    }

    private void checkRate(Double rate) {
        if (rate <= 0)
            throw new UnsupportedOperationException("No rate could be found");
    }

    private void checkConvertedAmount(Double amount, Double rate) {
        if (rate * amount > Double.MAX_VALUE)
            throw new IllegalArgumentException("Converted amount is greater than double maxvalue");
    }
}
