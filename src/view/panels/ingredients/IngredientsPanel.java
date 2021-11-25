package view.panels.ingredients;

import view.components.MenuButton;
import view.panels.listeners.MenuButtonsActions;
import view.panels.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class IngredientsPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
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
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goBackButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }
}
