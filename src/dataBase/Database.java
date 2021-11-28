package dataBase;

import controller.JsonHandler;
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

    public static Database getInstance() {
        return instance;
    }

    public Ingredient getIngredient(int id) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId() == id) {
                return ingredient;
            }
        }
        throw new RuntimeException("No such ingredient");
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addIngredient(String name, int amount) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                ingredient.setQuantity(ingredient.getQuantity() + amount);
                return;
            }
        }
        ingredients.add(new Ingredient(name, amount));
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void addReceipt(Receipt receipt) {
        for (int i = 0; i < receipts.size(); i++) {
            if (receipts.get(i).getName().equals(receipt.getName())) {
                receipts.set(i, receipt);
                return;
            }
        }
        receipts.add(receipt);
    }

    public void updateIngredientList() {
        JsonHandler.writeIngredientList(ingredients);
    }

    public void updateReceiptList() {
        JsonHandler.writeReceiptList(receipts);
    }
}
