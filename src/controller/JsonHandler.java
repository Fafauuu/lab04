package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dataBase.Database;
import model.Ingredient;
import model.Receipt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private static final Gson gson = new Gson();
    private static final Database database = Database.getInstance();
    private static final Type ingredientListType = new TypeToken<ArrayList<Ingredient>>(){}.getType();
    private static final Type receiptListType = new TypeToken<ArrayList<Receipt>>(){}.getType();

    public static void readIngredientList(){
        List<Ingredient> ingredients;
        try {
            ingredients = gson.fromJson(new FileReader("ingredients.json"), ingredientListType);
            for (Ingredient ingredient : ingredients) {
                database.addIngredient(new Ingredient(ingredient.getName(), ingredient.getQuantity()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readReceiptList(){
        List<Receipt> receipts;
        try {
            receipts = gson.fromJson(new FileReader("receipts.json"), receiptListType);
            for (Receipt receipt : receipts) {
                database.addReceipt(receipt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
