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

    // function that creates the shopping list
    private void createShoppingList() {
        // accessing both lists from InputReader
        Map<String, Ingredient> availableThings = inputReader.getThingsAtHome();
        Map<String, Ingredient> neededThings = inputReader.getThingsNeeded();

        //looping through every item in list of needed things
        for (String key : neededThings.keySet()) {
            
            Ingredient neededIngredient = neededThings.get(key);

            //putting the correct amount of needed ingredients into the shopping list
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

    //function that prints the shopping list
    public void printShoppingList() {
        
        System.out.println("Shopping List:");
        for (Ingredient ingredient : shoppingList.values()) {
            System.out.println(ingredient.toString());
        }
    }
}
