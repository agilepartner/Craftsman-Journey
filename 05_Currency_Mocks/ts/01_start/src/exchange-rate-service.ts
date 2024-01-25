export interface ExchangeRateService {
  getChangeRate(from: string, to: string): number;
}
