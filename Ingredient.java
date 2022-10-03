public class Ingredient {
    
    private int amount;
    private String unit;
    private String name;

    public Ingredient(int amount, String unit, String name) {
        this.amount = amount;
        this.unit = unit;
        this.name = name;
    }

    public void setQuantity(int amount) {
        this.amount += amount;
    }

    public String toString() {
        return amount + " " + unit + " " + name;
    }
}
