package Application;
import java.util.ArrayList;
import java.util.List;
public class UserProfile {
    private int userId;
    private String username;
    private String password;

    private List<CustomIceCreamCombination> favoriteCombinations;

    public UserProfile(int userId, String username,String password) {
        this.userId = userId;
        this.username = username;
        this.password=password;
        this.favoriteCombinations = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<CustomIceCreamCombination> getFavoriteCombinations() {
        return favoriteCombinations;
    }

    public void addFavoriteCombination(CustomIceCreamCombination combination) {
        favoriteCombinations.add(combination);
    }

    public void removeFavoriteCombination(CustomIceCreamCombination combination) {
        favoriteCombinations.remove(combination);
    }

    public CustomIceCreamCombination findFavoriteCombinationById(int combinationId) {
        for (CustomIceCreamCombination combination : favoriteCombinations) {
            if (combination.getCombinationId() == combinationId) {
                return combination;
            }
        }
        return null;
    }

    public List<CustomIceCreamCombination> searchFavorites(String keyword) {
        List<CustomIceCreamCombination> searchResults = new ArrayList<>();
        for (CustomIceCreamCombination combination : favoriteCombinations) {
            if (combination.getCustomName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(combination);
            }
        }
        return searchResults;
    }
}
