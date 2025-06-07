package Application;

public class CreditCardPayment implements PaymentOptions{
    @Override
    public void processNewPayment(Order order) {
        System.out.println("Processing credit card payment for Order #: " + order.getOrderId());
    }
}
