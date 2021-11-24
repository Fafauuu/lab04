package view.panels.mainMenu;

import view.components.MenuButton;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private MainMenuListener mainMenuListener;
    private MenuButton checkIngredientsButton;
    private MenuButton checkReceiptsButton;

    public MainMenuPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 420, 420);
        this.setBackground(Color.RED);

        setCheckIngredientsButton();
        setCheckReceiptsButton();
    }

    private void setCheckIngredientsButton() {
        checkIngredientsButton = new MenuButton(0, 0, 200, 40, "INGREDIENTS");
        checkIngredientsButton.setEnabled(true);

        checkIngredientsButton.addActionListener(e -> {
            if (e.getSource() == checkIngredientsButton && mainMenuListener != null) {
                mainMenuListener.actionChosen(MainMenuActions.INGREDIENTS);
            }
        });

        this.add(checkIngredientsButton);
    }

    private void setCheckReceiptsButton() {
        checkReceiptsButton = new MenuButton(0, 50, 200, 40, "RECEIPTS");
        checkReceiptsButton.setEnabled(true);

        checkReceiptsButton.addActionListener(e -> {
            if (e.getSource() == checkReceiptsButton && mainMenuListener != null) {
                mainMenuListener.actionChosen(MainMenuActions.RECEIPTS);
            }
        });

        this.add(checkReceiptsButton);
    }

    public void setMainMenuListener(MainMenuListener mainMenuListener) {
        this.mainMenuListener = mainMenuListener;
    }
}
