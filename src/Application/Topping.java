package Application;
import java.util.ArrayList;
import java.util.List;
public class Topping {
    private static List<Topping> availableToppings = new ArrayList<>();

    static {
        availableToppings.add(new Topping(1, "Sliced almonds", 15.50));
        availableToppings.add(new Topping(2, "Sprinkles", 17.00));
        availableToppings.add(new Topping(3, "Marshmallows", 30.25));
        availableToppings.add(new Topping(4, "Butterscotch chips", 56.75));
    }
    private int toppingId;
    private String toppingName;
    private double price;

    public Topping(int toppingId, String toppingName, double price) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.price = price;
    }
    public int getToppingId() {
        return toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public double getPrice() {
        return price;
    }

    public static List<Topping> getAvailableToppings() {
        return availableToppings;
    }

    @Override
    public String toString() {
        return toppingName; // Assuming toppingName is a field in your Topping class
    }

    public static Topping getToppingById(int toppingId) {
        for (Topping topping : availableToppings) {
            if (topping.getToppingId() == toppingId) {
                return topping;
            }
        }
        return null;
    }
}
