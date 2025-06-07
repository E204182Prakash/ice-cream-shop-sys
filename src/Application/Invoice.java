package Application;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Invoice {
    private Order order;
    private Date issueDate;
    private double totalAmount;

    public Invoice(Order order) {
        this.order = order;
        this.issueDate = new Date();
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        // Implement your logic to calculate the total amount based on the order details
        return order.getCustomIceCream().getPrice();
    }

    public void generateInvoice() {
        System.out.println("INVOICE");
        System.out.println("----------------------------");
        System.out.println("Invoice for Order #" + order.getOrderId());
        System.out.println("Issue Date: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(issueDate));
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Order Details:");
        order.reviewOrder();
        System.out.println("Total Amount: RS." + totalAmount);
        System.out.println("Thank you for choosing our ice cream shop!");
        System.out.println("----------------------------");
    }

}
