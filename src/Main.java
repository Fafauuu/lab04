import controller.fileHandlers.JsonHandler;
import dataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        JsonHandler.readIngredientList(dataBase);
        JsonHandler.readReceiptList(dataBase);
        System.out.println(dataBase.getIngredients());
        System.out.println(dataBase.getReceipts());
    }
}
