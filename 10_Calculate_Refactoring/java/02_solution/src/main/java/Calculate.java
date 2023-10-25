// Exercise: refactor me
public class Calculate 
{
    public static double calculate(double amount, int type, int years)
    {
        CustomerType customerType = CustomerType.values()[type - 1];
        return  calculate(amount, customerType, years);
    }

    public static double calculate(double amount, CustomerType type, int years)
    {
        double amountMinusRatio = amountMinusRatio(amount, type.ratio());
        return amountMinusRatio - type.discount(years) * amountMinusRatio;
    }

    private static double amountMinusRatio(double amount, double ratio) {
        return  amount - (amount * ratio);
    }
}