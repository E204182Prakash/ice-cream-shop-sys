package Application;

public class DeliveryState implements OrderState{
    private Order order;

    public DeliveryState(Order order) {
        this.order = order;
    }

    @Override
    public void placeOrder(Order order) {
        System.out.println("Order is already placed.");
    }

    @Override
    public void prepareOrder(Order order) {
        System.out.println("Cannot prepare an order that is already being delivered.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Order is already out for delivery.");
    }

}
