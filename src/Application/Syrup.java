package Application;
import java.util.ArrayList;
import java.util.List;
public class Syrup {
    private static List<Syrup> availableSyrups = new ArrayList<>();

    static {
        availableSyrups.add(new Syrup(1, "Caramel", 150.50));
        availableSyrups.add(new Syrup(2, "Chocolate", 100.25));
        availableSyrups.add(new Syrup(3, "Strawberry", 180.75));
        availableSyrups.add(new Syrup(4, "Blue Raspberry", 280.00));
    }

    private int syrupId;
    private String syrupName;
    private double price;

    public Syrup(int syrupId, String syrupName, double price) {
        this.syrupId = syrupId;
        this.syrupName = syrupName;
        this.price = price;
    }
    public int getSyrupId() {
        return syrupId;
    }

    public String getSyrupName() {
        return syrupName;
    }

    public double getPrice() {
        return price;
    }

    public static List<Syrup> getAvailableSyrups() {
        return availableSyrups;
    }

    @Override
    public String toString() {
        return syrupName;
    }
    public static Syrup getSyrupById(int syrupId) {
        for (Syrup syrup : availableSyrups) {
            if (syrup.getSyrupId() == syrupId) {
                return syrup;
            }
        }
        return null;
    }
}
