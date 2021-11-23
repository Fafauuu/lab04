package dataBase;

import model.Ingredient;
import model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<Ingredient> ingredients;
    private final List<Receipt> receipts;

    public DataBase() {
        this.ingredients = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }
}
