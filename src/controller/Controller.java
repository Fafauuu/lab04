package controller;

import view.frames.MainFrame;
import view.panels.listeners.MenuButtonsActions;
import view.panels.listeners.MenuButtonsListener;
import view.panels.receipts.ReceiptsPanelListener;

public class Controller implements MenuButtonsListener, ReceiptsPanelListener {
    private final MainFrame mainFrame;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void buttonClicked(MenuButtonsActions action) {
        System.out.println(action + " action performed");
        if (MenuButtonsActions.INGREDIENTS.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getIngredientsPanel());
        }
        if (MenuButtonsActions.MAIN_MENU.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getMainMenuPanel());
        }
        if (MenuButtonsActions.RECEIPTS.equals(action)){
            mainFrame.setActivePanel(mainFrame.getReceiptsPanel());
        }
    }

    @Override
    public void receiptChosen() {

    }
}
