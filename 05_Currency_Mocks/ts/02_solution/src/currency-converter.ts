import { ExchangeRateService } from "./exchange-rate-service";

export class CurrencyConverter {
  exchangeRates: ExchangeRateService;

  constructor(exchangeRates: ExchangeRateService) {
    this.exchangeRates = exchangeRates;
  }

  convert(from: string, to: string, amount: number) {
    this.checkCurrency(from, "from");
    this.checkCurrency(to, "to");
    this.checkAmount(amount);

    const rate = this.exchangeRates.getChangeRate(from, to);

    this.checkExchangeRate(rate, from, to);
    this.checkConvertedAmount(amount, rate);

    return amount * rate;
  }

  private checkCurrency(currency: string, name: string) {
    if (currency.length == 0)
      throw new CurrencyParamError(`'${name}' currency is not specified`);
  }

  private checkAmount(amount: number) {
    if (amount <= 0) throw new AmountParamError("Amount should be positive");
  }

  private checkExchangeRate(rate: number, from: string, to: string) {
    if (rate <= 0)
      throw new ExchangeRateError(
        `No exchange rate from '${from}' to '${to}' was found`
      );
  }

  private checkConvertedAmount(amount: number, rate: number) {
    if (amount * rate > Number.MAX_VALUE)
      throw new ConvertionError(
        "Converted amount is more that the maximum value"
      );
  }
}

export class CurrencyParamError extends Error {
  constructor(message: string) {
    super(message);
  }
}
export class AmountParamError extends Error {
  constructor(message: string) {
    super(message);
  }
}

export class ExchangeRateError extends Error {
  constructor(message: string) {
    super(message);
  }
}

export class ConvertionError extends Error {
  constructor(message: string) {
    super(message);
  }
}
