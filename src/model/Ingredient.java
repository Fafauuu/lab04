package model;

public class Ingredient {
    private final String name;
    private final int quantity;
    private final int id;
    private static int ingredientCount;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.id = ingredientCount;
        ingredientCount++;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public static int getIngredientCount() {
        return ingredientCount;
    }

    @Override
    public String toString() {
        return name;
    }
}
