package Application;

public class OrderTrackingSystem {
    public static void sendOrderConfirmationNotification(Order order) {
        SMSService.sendSMS(order.getCustomer().getPhoneNumber(), "Your ice cream order is confirmed. Thank you!");
    }

    public static void sendPreparationNotification(Order order) {
        SMSService.sendSMS(order.getCustomer().getPhoneNumber(), "Your ice cream is being prepared");
    }

    public static void sendOutForDeliveryNotification(Order order) {
        SMSService.sendSMS(order.getCustomer().getPhoneNumber(), "Your ice cream is out for delivery");
    }

    public static void sendDeliveryCompletedNotification(Order order) {
        SMSService.sendSMS(order.getCustomer().getPhoneNumber(), "Your ice cream delivery is completed");
    }
}
