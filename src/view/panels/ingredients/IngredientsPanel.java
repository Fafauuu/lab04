package view.panels.ingredients;

import view.components.MenuButton;

import javax.swing.*;
import java.awt.*;

public class IngredientsPanel extends JPanel {
    private IngredientsPanelListener ingredientsPanelListener;
    private MenuButton goBackButton;

    public IngredientsPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setBackground(Color.CYAN);

        setGoBackButton();
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(0, 0, 200, 40, "GO BACK");
        goBackButton.setEnabled(true);

        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && ingredientsPanelListener != null) {
                ingredientsPanelListener.actionChosen(IngredientsPanelActions.GO_BACK);
            }
        });

        this.add(goBackButton);
    }

    public void setIngredientsPanelListener(IngredientsPanelListener ingredientsPanelListener) {
        this.ingredientsPanelListener = ingredientsPanelListener;
    }
}
