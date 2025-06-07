package Application;

import java.util.List;
import java.util.ArrayList;

public class CustomIceCreamCombination implements Visitable,IceCreamDeco{
    private static int combinationCounter = 1;
    private int combinationId;
    private IceCreamFlavor flavor;
    private List<Topping> toppings;
    private List<Syrup> syrups;
    private ScoopSize size;
    private String customName;
    private double price;
    private Order order;
    private List<Double> prices;

    public CustomIceCreamCombination(Order order, List<Double> prices) {
        this.combinationId = combinationCounter++;
        this.toppings = new ArrayList<>();
        this.syrups = new ArrayList<>();
        this.order = order;
        this.prices = prices;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setCombinationId(int combinationId) {
        this.combinationId = combinationId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCombinationCounter() {
        return combinationCounter;
    }

    public int getCombinationId() {
        return combinationId;
    }

    public Order getOrder() {
        return order;
    }

    public IceCreamFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(IceCreamFlavor flavor) {
        this.flavor = flavor;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Syrup> getSyrups() {
        return syrups;
    }

    public void setSyrups(List<Syrup> syrups) {
        this.syrups = syrups;
    }

    public ScoopSize getSize() {
        return size;
    }

    public void setSize(ScoopSize size) {
        this.size = size;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getDecoDescription() {
        return "Custom Ice Cream Combination";
    }

    @Override
    public double getDecoPrice() {
        return price;
    }


    public double getPrice() {

        double totalPrice = flavor.getPrice();
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        for (Syrup syrup : syrups) {
            totalPrice += syrup.getPrice();
        }
        totalPrice += size.getPrice();
        return totalPrice;
    }

    public static void displayAvailableOptions() {
        System.out.println("Available Flavors:");
        for (IceCreamFlavor flavor : IceCreamFlavor.getAvailableFlavors()) {
            System.out.println(flavor.getFlavorId() + ". " + flavor.getFlavorName() + " - RS." + flavor.getPrice());
        }

        System.out.println("\nAvailable Toppings:");
        for (Topping topping : Topping.getAvailableToppings()) {
            System.out.println(topping.getToppingId() + ". " + topping.getToppingName() + " - RS." + topping.getPrice());
        }

        System.out.println("\nAvailable Syrups:");
        for (Syrup syrup : Syrup.getAvailableSyrups()) {
            System.out.println(syrup.getSyrupId() + ". " + syrup.getSyrupName() + " - RS." + syrup.getPrice());
        }

        System.out.println("\nAvailable Sizes:");
        for (ScoopSize size : ScoopSize.getAvailableSizes()) {
            System.out.println(size.getSizeId() + ". " + size.getSizeName() + " - RS." + size.getPrice());
        }
    }

    public boolean isDiscountable(SeasonalSpecial seasonalSpecial) {
        return seasonalSpecial.getDiscountedFlavors().isEmpty() || seasonalSpecial.getDiscountedFlavors().contains(flavor);
    }

    public List<CustomIceCreamCombination> getDiscountableCombinations() {
        // In a more sophisticated system, you would likely have a database or repository
        // to retrieve relevant combinations. This is a simplified example.
        List<CustomIceCreamCombination> discountableCombinations = new ArrayList<>();
        discountableCombinations.add(this); // Add the current combination for demonstration purposes
        // Add other relevant combinations based on your logic
        return discountableCombinations;
    }

    public static void setCombinationCounter(int combinationCounter) {
        CustomIceCreamCombination.combinationCounter = combinationCounter;
    }
    public void applySeasonalDiscount(SeasonalSpecial seasonalSpecial) {
        if (order != null && order.getCustomIceCream() != null) {
            // Apply the seasonal special discount to discountable combinations
            for (CustomIceCreamCombination combination : order.getCustomIceCream().getDiscountableCombinations()) {
                double discountAmount = combination.getPrice() * (seasonalSpecial.getDiscountPercentage() / 100);
                combination.setPrice(combination.getPrice() - discountAmount);
                System.out.println("Seasonal special '" + seasonalSpecial.getName() + "' applied to " + combination.getCustomName() +
                        ". Discounted amount: RS." + discountAmount);
            }
        }
    }
}
