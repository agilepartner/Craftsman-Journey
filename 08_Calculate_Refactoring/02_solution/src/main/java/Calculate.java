// Exercise: refactor me
public class Calculate 
{

    public static final double SIMPLE_CUSTOMER_RATIO = 0.1;
    public static final double VALUABLE_CUSTOMER_RATIO = 0.3;
    public static final double MOST_VALUABLE_CUSTOMER_RATIO = 0.5;

    /**
     * Calculate the price of a given item for a specified customer
     * @param amount price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return The price
     */
    public static double calculate(double amount, int type, int years)  
    {  
        double result = 0;  
        double disc = (years > 5) ? (double)5 / 100 : (double)years / 100;

        // NotRegistered  
        if (type == 1)  
        {  
                result = amount;
                return result;
        }  
        // SimpleCustomer  
        else if (type == 2)  
        {  
            result = (amount - (SIMPLE_CUSTOMER_RATIO * amount)) - disc * (amount - (SIMPLE_CUSTOMER_RATIO * amount));
        }  
        // ValuableCustomer  
        else if (type == 3)  
        {  
            result = (amount - (VALUABLE_CUSTOMER_RATIO * amount)) - disc * (amount - (VALUABLE_CUSTOMER_RATIO * amount));
        }  
        // MostValuableCustomer  
        else if (type == 4)  
        {  
            result = (amount - (MOST_VALUABLE_CUSTOMER_RATIO * amount)) - disc * (amount - (MOST_VALUABLE_CUSTOMER_RATIO * amount));
        }  
        return result;  
    }
}