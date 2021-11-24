package dataBase;

import model.Ingredient;
import model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final Database instance = new Database();
    private final List<Ingredient> ingredients;
    private final List<Receipt> receipts;

    private Database() {
        this.ingredients = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }

    public static Database getInstance(){
        return instance;
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
