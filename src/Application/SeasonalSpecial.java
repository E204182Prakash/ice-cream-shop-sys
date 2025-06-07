package Application;
import java.util.ArrayList;
import java.util.List;
public class SeasonalSpecial {
    private String name;
    private String description;
    private double discountPercentage;
    private List<IceCreamFlavor> discountedFlavors;

    public SeasonalSpecial(String name, String description, double discountPercentage) {
        this.name = name;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.discountedFlavors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public List<IceCreamFlavor> getDiscountedFlavors() {
        return discountedFlavors;
    }

    public void addDiscountedFlavor(IceCreamFlavor flavor) {
        discountedFlavors.add(flavor);
    }

    public void removeDiscountedFlavor(IceCreamFlavor flavor) {
        discountedFlavors.remove(flavor);
    }

    public boolean isFlavorDiscounted(IceCreamFlavor flavor) {
        return discountedFlavors.contains(flavor);
    }

    public void applyDiscount(Order order) {
        for (CustomIceCreamCombination combination : order.getCustomIceCream().getDiscountableCombinations()) {
            combination.applySeasonalDiscount(this);
        }
    }
}
