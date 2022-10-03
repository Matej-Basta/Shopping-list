import java.util.Map;
import java.util.TreeMap;

public class ShoppingList {
    
    private InputReader inputReader;
    private Map<String, Ingredient> shoppingList;

    public ShoppingList() {
        inputReader = new InputReader();
        shoppingList = new TreeMap<>();
        createShoppingList();
    }

    private void createShoppingList() {
        Map<String, Ingredient> availableThings = inputReader.getThingsAtHome();
        Map<String, Ingredient> neededThings = inputReader.getThingsNeeded();

        for (String key : neededThings.keySet()) {
            
            Ingredient neededIngredient = neededThings.get(key);

            if (availableThings.containsKey(key)) {
                Ingredient availableIngredient = availableThings.get(key);
                if (availableIngredient.getAmount() < neededIngredient.getAmount()) {
                    neededIngredient.updateQuantity(availableIngredient.getAmount());
                    shoppingList.put(key, neededIngredient);
                }
            } else {
                shoppingList.put(key, neededIngredient);
            }
        }
    }

    public void printShoppingList() {
        
        System.out.println("Shopping List:");
        for (Ingredient ingredient : shoppingList.values()) {
            System.out.println(ingredient.toString());
        }
    }
}
