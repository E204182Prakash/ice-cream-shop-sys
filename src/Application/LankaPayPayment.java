package Application;

public class LankaPayPayment implements PaymentOptions{
    @Override
    public void processNewPayment(Order order) {
        System.out.println("Processing LankaPayPayment payment for Order #" + order.getOrderId());
    }
}
