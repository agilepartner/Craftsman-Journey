public class Calculate {

    public class DiscountManager {
        private final AccountDiscountCalculatorFactory factory;
        private final LoyaltyDiscountCalculator loyaltyDiscountCalculator;

        public DiscountManager(AccountDiscountCalculatorFactory factory,
                               LoyaltyDiscountCalculator loyaltyDiscountCalculator) {
            this.factory = factory;
            this.loyaltyDiscountCalculator = loyaltyDiscountCalculator;
        }

        public double applyDiscount(double price, AccountType type, int yearsOwningAccount) {
            double pricesAfterAccountTypeDiscount = factory.GetAccountDiscountCalculator(type).applyDiscount(price);

            return loyaltyDiscountCalculator
                    .applyDiscount(pricesAfterAccountTypeDiscount, yearsOwningAccount);
        }
    }

    public class LoyaltyDiscountCalculatorImpl implements LoyaltyDiscountCalculator {

        @Override
        public double applyDiscount(double price, int yearsOwningAccount) {
            double discountForLoyalty = (yearsOwningAccount > Constants.MAXIMUM_DISCOUNT_FOR_LOYALTY)
                    ? (double) Constants.MAXIMUM_DISCOUNT_FOR_LOYALTY / 100
                    : (double) yearsOwningAccount / 100;
            return price - (discountForLoyalty * price);
        }
    }

    public class AccountDiscountCalculatorImpl implements AccountDiscountCalculator {

        private  double discountRate;

        public AccountDiscountCalculatorImpl(double discountRate) {
            this.discountRate = discountRate;
        }

        @Override
        public double applyDiscount(double price) {
            return (price - (discountRate * price));
        }
    }

    public class AccountDiscountCalculatorFactoryImpl implements AccountDiscountCalculatorFactory {
        @Override
        public AccountDiscountCalculator GetAccountDiscountCalculator(AccountType type) {
            switch (type) {
                case NotRegistered:
                    return new AccountDiscountCalculatorImpl(0);
                case StandardCustomer:
                    return new AccountDiscountCalculatorImpl(Constants.DISCOUNT_FOR_STANDARD_CUSTOMER);
                case ValuableCustomer:
                    return new AccountDiscountCalculatorImpl(Constants.DISCOUNT_FOR_VALUABLE_CUSTOMER);
                case MostValuableCustomer:
                    return new AccountDiscountCalculatorImpl(Constants.DISCOUNT_FOR_MOST_VALUABLE_CUSTOMER);
                default:
                    throw new RuntimeException("Type not found");
            }
        }
    }

    public enum AccountType {
        NotRegistered,
        StandardCustomer,
        ValuableCustomer,
        MostValuableCustomer,
    }

    public static class Constants {
        public static final int MAXIMUM_DISCOUNT_FOR_LOYALTY = 5;
        public static final double DISCOUNT_FOR_STANDARD_CUSTOMER = 0.1;
        public static final double DISCOUNT_FOR_VALUABLE_CUSTOMER = 0.3;
        public static final double DISCOUNT_FOR_MOST_VALUABLE_CUSTOMER = 0.5;
    }

    public interface LoyaltyDiscountCalculator {
        double applyDiscount(double price, int yearsOwningAccount);
    }

    public interface AccountDiscountCalculator {
        double applyDiscount(double price);
    }

    public interface AccountDiscountCalculatorFactory {
        AccountDiscountCalculator GetAccountDiscountCalculator(AccountType type);
    }

}
