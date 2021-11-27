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
        addListeners(mainFrame, controller);
    }

    private static void addListeners(MainFrame mainFrame, Controller controller) {
        mainFrame.getMainMenuPanel().setMenuButtonsListener(controller);
        mainFrame.getIngredientsPanel().setMenuButtonsListener(controller);
        mainFrame.getIngredientsPanel().getSplitPane().setIngredientListListener(controller);
        mainFrame.getReceiptsPanel().setMenuButtonsListener(controller);
        mainFrame.getReceiptsPanel().getSplitPane().setReceiptListListener(controller);
        mainFrame.getPrepareMealPanel().setMenuButtonsListener(controller);
        mainFrame.getPrepareMealPanel().setPrepareMealListener(controller);
    }
}
