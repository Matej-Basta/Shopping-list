import java.util.Map;
import java.util.TreeMap;

public class ShoppingList {
    
    private InputReader inputReader;
    private Map<String, Ingredient> shoppingList;

    public ShoppingList() {
        inputReader = new InputReader();
        shoppingList = new TreeMap<>();
    }

    public void createShoppingList() {
        Map<String, Ingredient> availableThings = inputReader.getThingsAtHome();
        Map<String, Ingredient> neededThings = inputReader.getThingsNeeded();
    }
    /* public printShoppingList() {
        
    } */
}
