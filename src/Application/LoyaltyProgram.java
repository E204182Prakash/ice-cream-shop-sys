package Application;

public class LoyaltyProgram {
    private static final int purchasePoints = 10;
    private static final int discountPoints = 50;
    private static final int freeScoopPoints = 100;
    private static final int priorityDeliveryPoints = 150;

    public static void earnPoints(Customer customer, double purchaseAmount) {
        int earnedPoints = (int) (purchaseAmount / 10);
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + earnedPoints);
        System.out.println("You earned " + earnedPoints + " loyalty points!");
    }

    public static void redeemPoints(Customer customer, int pointsToRedeem) {
        if (customer.getLoyaltyPoints() >= pointsToRedeem) {
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() - pointsToRedeem);
            System.out.println("You redeemed " + pointsToRedeem + " loyalty points.");
        } else {
            System.out.println("Not enough loyalty points to redeem.");
        }
    }
}
