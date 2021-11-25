package view.panels.mainMenu;

import view.components.MenuButton;
import view.panels.listeners.MenuButtonsActions;
import view.panels.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
    private MenuButton checkIngredientsButton;
    private MenuButton checkReceiptsButton;

    public MainMenuPanel() {
        this.setLayout(null);
        this.setBounds(0,0,420,420);
        this.setBackground(Color.RED);

        setCheckIngredientsButton();
        setCheckReceiptsButton();
    }

    private void setCheckIngredientsButton() {
        checkIngredientsButton = new MenuButton(0, 0, 200, 40, "INGREDIENTS");
        checkIngredientsButton.setEnabled(true);

        checkIngredientsButton.addActionListener(e -> {
            if (e.getSource() == checkIngredientsButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.INGREDIENTS);
            }
        });

        this.add(checkIngredientsButton);
    }

    private void setCheckReceiptsButton() {
        checkReceiptsButton = new MenuButton(0, 50, 200, 40, "RECEIPTS");
        checkReceiptsButton.setEnabled(true);

        checkReceiptsButton.addActionListener(e -> {
            if (e.getSource() == checkReceiptsButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.RECEIPTS);
            }
        });

        this.add(checkReceiptsButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }
}
