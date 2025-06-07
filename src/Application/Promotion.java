package Application;

public class Promotion {
    private String name;
    private String description;
    private double discountPercentage;

    public Promotion(String name, String description, double discountPercentage) {
        this.name = name;
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
