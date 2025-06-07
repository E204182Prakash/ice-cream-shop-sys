package Application;

public class PreparationState implements OrderState{
    private Order order;

    public PreparationState(Order order) {
        this.order = order;
    }

    @Override
    public void placeOrder(Order order) {
        System.out.println("Order is already placed.");
    }

    @Override
    public void prepareOrder(Order order) {
        System.out.println("Order is already being prepared.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivering the order.");
        order.setCurrentState(new DeliveryState(order));
    }
}
