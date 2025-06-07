package Application;

public interface OrderState {
    void placeOrder(Order order);

    void prepareOrder(Order order);

    void deliverOrder(Order order);
}
