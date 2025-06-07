package Application;
import java.util.ArrayList;
import java.util.List;
public class RatingManager {
    private List<Feedback> feedbackList;

    public RatingManager() {
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public double getAverageRating(int orderId) {
        int totalRating = 0;
        int count = 0;
        for (Feedback feedback : feedbackList) {
            if (feedback.getOrderId() == orderId) {
                totalRating += feedback.getRating();
                count++;
            }
        }
        return (count > 0) ? ((double) totalRating / count) : 0.0;
    }

    public List<CustomIceCreamCombination> getHighlyRatedCombinations() {
        List<CustomIceCreamCombination> highlyRatedCombinations = new ArrayList<>();
        return highlyRatedCombinations;
    }
}
