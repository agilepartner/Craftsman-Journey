public class Calculate {

    public double calculate(double amount, int type, int years)
    {
        double result = 0;
        double disc = (years > 5) ? (double) 5 / 100 : (double) years / 100;

        // NotRegistered
        if (type == 1)
        {
            result = amount;
            return  result;
        }
        // SimpleCustomer
        else if (type == 2)
        {
            result = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
        }
        // ValuableCustomer
        else if (type == 3)
        {
            result = (0.7 * amount) - disc * (0.7 * amount);
            return  result;
        }
        // MostValuableCustomer
        else if (type == 4)
        {
            result = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));
        }
        return  result;
    }

}
