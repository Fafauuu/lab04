package view.panels.ingredients;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.panels.PanelsColor;

import javax.swing.*;

public class IngredientsPanel extends JPanel {
    private final IngredientsSplitPane splitPane;
    private static MenuButtonsListener menuButtonsListener;
    private MenuButton goBackButton;
    private MenuButton addIngredientButton;

    public IngredientsPanel() {
        splitPane = new IngredientsSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(PanelsColor.PANEL_COLOR);

        splitPane.setBounds(0,0,390,280);
        this.add(splitPane);

        setGoBackButton();
        setAddIngredientButton();
    }

    public void refreshSize(){
        this.setBounds(0, 0, 400, 400);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 300, 150, 40, "GO BACK");
        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goBackButton);
    }

    private void setAddIngredientButton() {
        addIngredientButton = new MenuButton(215, 300, 150, 40, "ADD INGREDIENT");
        addIngredientButton.addActionListener(e -> {
            if (e.getSource() == addIngredientButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.ADD_INGREDIENT);
            }
        });

        this.add(addIngredientButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        IngredientsPanel.menuButtonsListener = menuButtonsListener;
    }

    public IngredientsSplitPane getSplitPane() {
        return splitPane;
    }
}
