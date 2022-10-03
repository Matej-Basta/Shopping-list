import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class InputReader {
    
    private Map<String, Ingredient> thingsAtHome;
    private Map<String, Ingredient> thingsNeeded;

    public InputReader() {
        thingsAtHome = new HashMap<>();
        thingsNeeded = new HashMap<>();
        readInput();
    }
    
    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        //will be used to decide to what list the item will go
        char keyword = Character.MIN_VALUE;

        while(scanner.hasNext()) {

            String input = scanner.nextLine();
            // setting the keyword to either "A" as available or "R" as recipes
            if (input.equals("AVAILABLE") || input.contains("RECIPE")) {
                keyword = input.charAt(0);
                continue;
            }
            
            // converting input line into an array
            String[] inputArray = input.split(" ");
            
            //converting everything to grams
            if (inputArray[1].equals("kg")) {
                inputArray[0] += "000";
                inputArray[1] = "g";
            }

            switch (keyword) {
                // adding new ingredients to the list of available ingredients
                case 'A':
                    thingsAtHome.put(inputArray[2], new Ingredient(Integer.parseInt(inputArray[0]), inputArray[1], inputArray[2]));
                    break;
                // adding new ingredients to the list of needed ingredients or updating the amount needed
                case 'R':
                    if (thingsNeeded.containsKey(inputArray[2])) {
                        Ingredient ingredientAgain = thingsNeeded.get(inputArray[2]);
                        ingredientAgain.setQuantity(Integer.parseInt(inputArray[0]));
                    } else {
                        thingsNeeded.put(inputArray[2], new Ingredient(Integer.parseInt(inputArray[0]), inputArray[1], inputArray[2]));
                    }
                    break;
            }
        }

        scanner.close();
    }

    public Map<String, Ingredient> getThingsAtHome() {
        return thingsAtHome;
    }

    public Map<String, Ingredient> getThingsNeeded() {
        return thingsNeeded;
    }
    
}
