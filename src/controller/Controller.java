package controller;

import view.panels.ingredients.IngredientsPanelActions;
import view.panels.ingredients.IngredientsPanelListener;
import view.panels.mainMenu.MainMenuActions;
import view.panels.mainMenu.MainMenuListener;
import view.frames.MainFrame;

public class Controller implements MainMenuListener, IngredientsPanelListener {
    private final MainFrame mainFrame;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionChosen(MainMenuActions action) {
        System.out.println(action + " action performed");
        if (MainMenuActions.INGREDIENTS.equals(action)){
            mainFrame.setActivePanel(mainFrame.getIngredientsPanel());
        }
    }

    @Override
    public void actionChosen(IngredientsPanelActions action) {
        System.out.println(action + " action performed");
        if (IngredientsPanelActions.GO_BACK.equals(action)){
            mainFrame.setActivePanel(mainFrame.getMainMenuPanel());
        }
    }
}
