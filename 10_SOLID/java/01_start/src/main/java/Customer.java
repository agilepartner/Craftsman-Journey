import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Customer {
    /*
        0 : normal
        1 : gold
    */
    private final int customerType;

    public Customer(int type) {
        customerType = type;
    }

    public int getDiscount() {
        if (customerType == 1) {
            return 50;
        } else {
            return 10;
        }
    }

    public void save() throws IOException {
        try {
            // Code to save in database code goes here
        }
        catch (Exception e) {
            PrintWriter pw = new PrintWriter(new File("error.txt"));
            e.printStackTrace(pw);
            pw.close();
        }
    }
}
