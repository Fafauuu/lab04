import controller.Controller;
import controller.JsonHandler;
import dataBase.Database;
import view.frames.MainFrame;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        JsonHandler.readIngredientList();
        JsonHandler.readReceiptList();
        System.out.println(database.getIngredients());
        System.out.println(database.getReceipts());
        MainFrame mainFrame = new MainFrame();
        Controller controller = new Controller(mainFrame);
        mainFrame.getMainMenuPanel().setMainMenuListener(controller);
        mainFrame.getIngredientsPanel().setIngredientsPanelListener(controller);
    }
}
