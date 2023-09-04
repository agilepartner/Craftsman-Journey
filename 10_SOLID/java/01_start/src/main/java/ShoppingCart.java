import io.vavr.collection.List;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<CartIem> items;

    public ShoppingCart() {
        this.items = new ArrayList<CartIem>();
    }

    public double getDiscountPercentage() {
        double amount = 0;
        if (items.size() >= 5 && items.size() < 10) {
            amount = 10;
        }
        else if (items.size() >= 10 && items.size() < 15){
            amount = 15;
        }

        return amount;
    }

    public void add(CartIem item) {
        items.add(item);
    }

    public void remove(CartIem item) {
        items.remove(item);
    }

    public class CartIem {

    }
}
