import { Substitute, SubstituteOf } from "@fluffy-spoon/substitute";
import { CurrencyConverter } from "../src/currency-converter";
import { ExchangeRateService } from "../src/exchange-rate-service";

describe("CurrencyConverter should", () => {
  let currencyConverter: CurrencyConverter;
  let exchangeRates: SubstituteOf<ExchangeRateService>;

  beforeEach(() => {
    exchangeRates = Substitute.for<ExchangeRateService>();
    currencyConverter = new CurrencyConverter(exchangeRates);
  });

  it("fail", () => {
    exchangeRates.getChangeRate("USD", "EUR").returns(1.1);
    expect(exchangeRates.getChangeRate("USD", "EUR")).toBe(1.2);
  });
});
