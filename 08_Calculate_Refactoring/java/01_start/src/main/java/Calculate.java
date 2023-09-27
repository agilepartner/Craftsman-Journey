// Exercise: refactor me
public class Calculate 
{
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
            result = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));  
        }  
        // ValuableCustomer  
        else if (type == 3)  
        {  
            result = (amount - (0.3 * amount)) - disc * (amount - (0.3 * amount));   
        }  
        // MostValuableCustomer  
        else if (type == 4)  
        {  
            result = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));  
        }  
        return result;  
    }


    // main is just used for basic testing //
    public static void main(String []args)
    throws CalculationException
    {
        // NotRegistered
        verify(100, 1, 3, 100);
        verify(100, 1, 5, 100);
        verify(100, 1, 10, 100);

        // SimpleCustomer 
        verify(100, 2, 3, 87.3);
        verify(100, 2, 5, 85.5); 
        verify(100, 2, 10, 85.5);

        // ValuableCustomer
        verify(100, 3, 3, 67.9);
        verify(100, 3, 5, 66.5);
        verify(100, 3, 10, 66.5);
        
        // MostValuableCustomer
        verify(100, 4, 3, 48.5);
        verify(100, 4, 5, 47.5);
        verify(100, 4, 10, 47.5);

        System.out.println("OK!!");
    }

    private static void verify(double amount, int type, int years, double expected) 
    throws CalculationException
    {
        double actual = calculate(amount, type, years);
        if(actual != expected)
        {
            throw new CalculationException(amount, type, years, actual, expected);
        }
    }

    private static class CalculationException extends Exception
    {
        private static final long serialVersionUID = 8412546891626406402L;

		public CalculationException(double amount, int type, int years, double actual, double expected)
        {
            super(amount + ", " + type + ", " + years + " years => " + expected + " NOT " + actual);
        }
    }
}