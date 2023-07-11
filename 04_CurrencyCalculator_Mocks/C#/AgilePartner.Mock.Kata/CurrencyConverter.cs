using System;

namespace AgilePartner.Mock.Kata
{
    public class CurrencyConverter
    {
        private readonly IChangeRateService changeRateService;
        public CurrencyConverter(IChangeRateService changeRateService)
        {
            this.changeRateService = changeRateService;
        }

        public double Convert(
            string fromCurrency, 
            string toCurrency, 
            double amount)
        {
            CheckAmount(amount);
            var rate = GetRate(fromCurrency, toCurrency);

            CheckRate(rate);

            var conversion = Convert(amount, rate);
            CheckConversionResult(conversion);

            return conversion;
        }

        private double Convert(
            double amount, 
            double rate)
        {
            return amount * rate;
        }

        private void CheckConversionResult(double conversion)
        {
            if (conversion >= double.MaxValue)
            {
                throw new InvalidOperationException("Result out of bound");
            }
        }

        private double GetRate(
            string fromCurrency, 
            string toCurrency)
        {
            try
            {
                return changeRateService.GetChangeRate(fromCurrency, toCurrency);
            }
            catch (Exception unknownEx) when(unknownEx.GetType() != typeof(ArgumentException))
            {
                throw new InvalidOperationException("An unexpected error has been thrown during the conversion", unknownEx);
            }
        }

        private static void CheckRate(double rate)
        {
            if (rate < 0)
            {
                throw new InvalidOperationException("Retrieved rate not equal or greater than zero");
            }
        }

        private static void CheckAmount(double amount)
        {
            if (amount < 0)
            {
                throw new ArgumentException("Amount must be equal or greater than zero");
            }
        }
    }
}
