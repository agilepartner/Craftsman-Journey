import { ExchangeRateService } from "./exchange-rate-service";

export class CurrencyConverter {
  exchangeRates: ExchangeRateService;

  constructor(exchangeRates: ExchangeRateService) {
    this.exchangeRates = exchangeRates;
  }

  convert(from: string, to: string, amount: number) {
    throw new Error("not implemented");
  }
}
