package model;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private final String name;
    private String description;
    private Map<Integer, Integer> ingredients;

    public Receipt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Integer, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Integer, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}