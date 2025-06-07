package Application;

import java.util.ArrayList;
import java.util.List;

public class IceCreamFlavor {
    private static List<IceCreamFlavor> availableFlavors = new ArrayList<>();

    static {
        availableFlavors.add(new IceCreamFlavor(1, "Chocolate", 450.50));
        availableFlavors.add(new IceCreamFlavor(2, "Vanilla", 450.00));
        availableFlavors.add(new IceCreamFlavor(3, "Strawberry", 1200.75));
        availableFlavors.add(new IceCreamFlavor(4, "Butter Pecan", 850.00));
    }

    private int flavorId;
    private String flavorName;
    private double price;

    public IceCreamFlavor(int flavorId, String flavorName, double price) {
        this.flavorId = flavorId;
        this.flavorName = flavorName;
        this.price = price;
    }

    public int getFlavorId() {
        return flavorId;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public double getPrice() {
        return price;
    }

    public static List<IceCreamFlavor> getAvailableFlavors() {
        return availableFlavors;
    }

    public static IceCreamFlavor getFlavorById(int flavorId) {
        for (IceCreamFlavor flavor : availableFlavors) {
            if (flavor.getFlavorId() == flavorId) {
                return flavor;
            }
        }
        return null; // Flavor not found
    }

    public boolean isPartOfSeasonalSpecial(SeasonalSpecial seasonalSpecial) {
        return seasonalSpecial.isFlavorDiscounted(this);
    }
}
