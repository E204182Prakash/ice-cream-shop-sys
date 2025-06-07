package Application;

import java.util.List;

public class PromotionService {
    private List<Promotion> activePromotions;

    public List<Promotion> getActivePromotions() {
        return activePromotions;
    }

    public void applyPromotion(Order order, Promotion promotion) {
        // Implement the logic to apply the promotion to the order
        // You may need to update the Order class to support promotions
        // For example, you could have a List<Promotion> field in the Order class
        // to keep track of applied promotions.
    }
}
