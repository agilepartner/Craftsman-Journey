abstract class Customer {
    protected double getDiscount() {
        return 0;
    }

    public double calculate(double amount, int years) {
        double discount = (years > 5) ? 0.05 : 0.01 * years;
        return amount * (1 - getDiscount()) - discount * amount * (1 - getDiscount());
    }

    public static Customer create(int type)
    {
        switch (type)
        {
            case 1:
                return new NotRegisteredCustomer();
            case 2:
                return new SimpleCustomer();
            case 3:
                return new ValuableCustomer();
            case 4:
                return  new MostValuableCustomer();
            default:
                throw new IllegalArgumentException("Customer type unknown");
        }
    }
}

class NotRegisteredCustomer extends Customer {
    @Override
    public double calculate(double amount, int years)
    {
        return amount;
    }
}

class SimpleCustomer extends Customer {
    @Override
    protected double getDiscount() {
        return 0.1;
    }
}

class ValuableCustomer extends Customer {
    @Override
    protected double getDiscount() {
        return 0.3;
    }
}

class MostValuableCustomer extends Customer {
    @Override
    protected double getDiscount() {
        return 0.5;
    }
}

public class Calculate
{
    public static double calculate(double amount, int type, int years)
    {
        Customer customer = Customer.create(type);
        return customer.calculate(amount, years);
    }
}