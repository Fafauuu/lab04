package view.panels.ingredients;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class IngredientsPanel extends JPanel {
    private final IngredientsSplitPane splitPane;
    private MenuButtonsListener menuButtonsListener;
    private MenuButton goBackButton;

    public IngredientsPanel() {
        splitPane = new IngredientsSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(Color.CYAN);

        splitPane.setBounds(0,0,390,280);
        this.add(splitPane);

        setGoBackButton();
    }

    public void refreshSize(){
        this.setBounds(0, 0, 400, 400);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 300, 200, 40, "GO BACK");
        goBackButton.setEnabled(true);

        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goBackButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }

    public IngredientsSplitPane getSplitPane() {
        return splitPane;
    }
}
