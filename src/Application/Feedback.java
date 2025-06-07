package Application;

public class Feedback {
    private int orderId;
    private String comment;
    private int rating;

    public Feedback(int orderId, String comment, int rating) {
        this.orderId = orderId;
        this.comment = comment;
        this.rating = rating;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public int provideFeedback(){
        return rating;
    }
}
