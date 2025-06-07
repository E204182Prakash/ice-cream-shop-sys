package Application;
import java.util.ArrayList;
import java.util.List;
public class ScoopSize {
    private static List<ScoopSize> availableSizes = List.of(
            new ScoopSize(1, "1 Scoop", 450.00),
            new ScoopSize(2, "2 Scoops", 550.50)
    );

    private int sizeId;
    private String sizeName;
    private double price;

    public ScoopSize(int sizeId, String sizeName, double price) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.price = price;
    }

    public int getSizeId() {
        return sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public double getPrice() {
        return price;
    }

    public static List<ScoopSize> getAvailableSizes() {
        return availableSizes;
    }

    public static ScoopSize getSizeById(int sizeId) {
        for (ScoopSize size : availableSizes) {
            if (size.getSizeId() == sizeId) {
                return size;
            }
        }
        return null;
    }
}
