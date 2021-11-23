package controller.fileHandlers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dataBase.DataBase;
import model.Ingredient;
import model.Receipt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private final static Gson gson = new Gson();
    private final static Type ingredientListType = new TypeToken<ArrayList<Ingredient>>(){}.getType();
    private final static Type receiptListType = new TypeToken<ArrayList<Receipt>>(){}.getType();

    public static void readIngredientList(DataBase dataBase){
        List<Ingredient> ingredients;
        try {
            ingredients = gson.fromJson(new FileReader("ingredients.json"), ingredientListType);
            for (Ingredient ingredient : ingredients) {
                dataBase.addIngredient(new Ingredient(ingredient.getName(), ingredient.getQuantity()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readReceiptList(DataBase dataBase){
        List<Receipt> receipts;
        try {
            receipts = gson.fromJson(new FileReader("receipts.json"), receiptListType);
            for (Receipt receipt : receipts) {
                dataBase.addReceipt(receipt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
