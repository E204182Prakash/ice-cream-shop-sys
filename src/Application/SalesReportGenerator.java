package Application;

import java.util.List;

public class SalesReportGenerator {
    private List<Order> orders;

    public SalesReportGenerator(List<Order> orders) {
        this.orders = orders;
    }
    public void generateSalesReport() {
        System.out.println("Sales Report");
        System.out.println("----------------------------");

        double totalSales = calculateTotalSales();

        System.out.println("Total Sales: $" + totalSales);
        System.out.println("\nOrder Details:");

        for (Order order : orders) {
            System.out.println("Order #" + order.getOrderId());
            System.out.println("Customer: " + order.getCustomer().getName());
            System.out.println("Order Type: " + order.getOrderType());
            System.out.println("Total Price: $" + order.getCustomIceCream().getPrice());
            System.out.println("----------------------------");
        }
    }

    private double calculateTotalSales() {
        double totalSales = 0.0;

        for (Order order : orders) {
            totalSales += order.getCustomIceCream().getPrice();
        }

        return totalSales;
    }

}
