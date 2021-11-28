package model;

public class Ingredient {
    private final String name;
    private int quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceAmount(int quantity) {
        this.quantity -= quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
