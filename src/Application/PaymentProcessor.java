package Application;

import java.time.LocalDateTime;

public class PaymentProcessor {

    public static void processPayment(Order order, PaymentMethod paymentMethod) {

        Payment payment = new Payment(1, LocalDateTime.now() , 1500, paymentMethod);
        payment.processPayment();

        // Simulate payment processing
        if (paymentMethod == PaymentMethod.CASH) {
            System.out.println("Payment processed successfully with cash.");
        }
        else if (paymentMethod == PaymentMethod.DEBIT_CARD) {
            System.out.println("Payment processed successfully with " + paymentMethod + ".");
        }
        else {
            System.out.println("Invalid payment method.");
        }
    }
}
