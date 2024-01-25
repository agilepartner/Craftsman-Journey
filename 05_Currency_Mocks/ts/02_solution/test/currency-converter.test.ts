import { Substitute, SubstituteOf } from "@fluffy-spoon/substitute";
import {
  AmountParamError,
  ConvertionError,
  CurrencyConverter,
  CurrencyParamError,
  ExchangeRateError,
} from "../src/currency-converter";
import { ExchangeRateService } from "../src/exchange-rate-service";

describe("CurrencyConverter should", () => {
  let currencyConverter: CurrencyConverter;
  let exchangeRates: SubstituteOf<ExchangeRateService>;

  beforeEach(() => {
    exchangeRates = Substitute.for<ExchangeRateService>();
    currencyConverter = new CurrencyConverter(exchangeRates);
  });

  it("convert when exchange rate is found", () => {
    exchangeRates.getChangeRate("USD", "EUR").returns(0.9);

    const actual = currencyConverter.convert("USD", "EUR", 100);

    expect(actual).toBe(90);
  });

  it("fail when rate is zero", () => {
    exchangeRates.getChangeRate("USD", "EUR").returns(0);

    expect(() => currencyConverter.convert("USD", "EUR", 100)).toThrow(
      ExchangeRateError
    );
  });

  it("fail when rate is negative", () => {
    exchangeRates.getChangeRate("USD", "EUR").returns(-10);

    expect(() => currencyConverter.convert("USD", "EUR", 100)).toThrow(
      ExchangeRateError
    );
  });

  it("fail when 'from' currency is empty", () => {
    expect(() => currencyConverter.convert("", "EUR", 100.0)).toThrow(
      CurrencyParamError
    );
  });

  it("fail when 'to' currency is empty", () => {
    expect(() => currencyConverter.convert("USD", "", 100.0)).toThrow(
      CurrencyParamError
    );
  });

  it("fail when amount is negative", () => {
    expect(() => currencyConverter.convert("USD", "EUR", -10)).toThrow(
      AmountParamError
    );
  });

  it("fail when amount is zero", () => {
    expect(() => currencyConverter.convert("USD", "EUR", 0)).toThrow(
      AmountParamError
    );
  });

  it("fail when converted amount is more that max value", () => {
    exchangeRates.getChangeRate("USD", "EUR").returns(Number.MAX_VALUE);

    expect(() =>
      currencyConverter.convert("USD", "EUR", Number.MAX_VALUE)
    ).toThrow(ConvertionError);
  });
});
