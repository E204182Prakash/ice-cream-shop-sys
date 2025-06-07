package Application;

public class DeliveryService {

    public void getDistance(){
        System.out.println("Getting distance...");
    }
    public static void estimateDeliveryTime(Order order, String deliveryAddress) {
        // In Future need to Integrate mapping service to estimate delivery time
        System.out.println("Estimated delivery time for Order " + order.getOrderId() + " to " + deliveryAddress + ": 30 minutes");
    }
}
