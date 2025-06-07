package Application;

public class PlacedState implements OrderState{
    private Order order;

    public PlacedState(Order order) {
        this.order = order;
    }

    @Override
    public void placeOrder(Order order) {
        System.out.println("Order is already placed.");
    }

    @Override
    public void prepareOrder(Order order) {
        System.out.println("Preparing the order.");
        order.setCurrentState(new PreparationState(order));
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver an order that is not prepared.");
    }
}
