package Application;

public class KOKOPayment implements PaymentOptions{
    @Override
    public void processNewPayment(Order order) {
        System.out.println("Processing KOKO payment for Order #" + order.getOrderId());
    }
}
