import controller.Controller;
import controller.JsonHandler;
import view.frames.MainFrame;

public class Main {
    public static void main(String[] args) {
        JsonHandler.readIngredientList();
        JsonHandler.readReceiptList();
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
        mainFrame.getAddIngredientPanel().setMenuButtonsListener(controller);
        mainFrame.getAddIngredientPanel().setAddIngredientListener(controller);
        mainFrame.getAddReceiptPanel().setMenuButtonsListener(controller);
        mainFrame.getAddReceiptPanel().setAddReceiptListener(controller);
    }
}
