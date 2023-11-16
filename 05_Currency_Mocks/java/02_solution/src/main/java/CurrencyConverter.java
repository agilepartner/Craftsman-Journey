public class CurrencyConverter {

    private final ExchangeRateService rates;

    public CurrencyConverter(ExchangeRateService rates) {
        if (rates == null)
            throw new UnsupportedOperationException("No exchange rate service was specified");
        this.rates = rates;
    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        CheckCurrency(fromCurrency, "From");
        CheckCurrency(toCurrency, "To");
        CheckAmout(amount);

        Double rate = rates.getRate(fromCurrency, toCurrency);
        CheckRate(rate);

        return rate * amount;
    }

    private void CheckCurrency(String currency, String name) {
        if (currency == null || currency.trim().isEmpty())
            throw new IllegalArgumentException("No '"+ name +"' currency specified");
    }

    private void CheckAmout(Double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount should be positive");
    }

    private void CheckRate(Double rate) {
        if (rate <= 0)
            throw new UnsupportedOperationException("No rate could be found");
    }
}
