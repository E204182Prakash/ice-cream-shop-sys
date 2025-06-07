package Application;

public class PriceCalculatorVisitor implements Visitor{
    private double totalPrice = 0.0;

    @Override
    public void visit(CustomIceCreamCombination customIceCream) {
        for (Double price : customIceCream.getPrices()) {
            totalPrice += price;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
