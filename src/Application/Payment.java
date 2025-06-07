package Application;
import java.time.LocalDateTime;

public class Payment {
    private int transactionId;
    private LocalDateTime timestamp;
    private double amount;
    private PaymentMethod paymentMethod;

    public Payment(int transactionId, LocalDateTime timestamp, double amount, PaymentMethod paymentMethod) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void processPayment() {
        System.out.println("Payment processed successfully with " + paymentMethod + ".");
    }
}
