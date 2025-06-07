package Application;

public class Customer implements OrderObserver{
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private int loyaltyPoints;

    public Customer(int customerId, String name, String phoneNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.loyaltyPoints = 0;
    }

    @Override
    public void update(Order order) {
        System.out.println("Order #" + order.getOrderId() + " status: " + order.getOrderStatus());
    }
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

}
