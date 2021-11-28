package view.panels.mainMenu;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
    private MenuButton checkIngredientsButton;
    private MenuButton checkReceiptsButton;
    private MenuButton prepareMealButton;

    public MainMenuPanel() {
        this.setLayout(null);
        refreshSize();
        this.setBackground(Color.RED);

        setCheckIngredientsButton();
        setCheckReceiptsButton();
        setPrepareMealButton();
    }

    public void refreshSize() {
        this.setBounds(0,0,420,420);
    }

    private void setCheckIngredientsButton() {
        checkIngredientsButton = new MenuButton(0, 0, 200, 40, "INGREDIENTS");
        checkIngredientsButton.addActionListener(e -> {
            if (e.getSource() == checkIngredientsButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.INGREDIENTS);
            }
        });

        this.add(checkIngredientsButton);
    }

    private void setCheckReceiptsButton() {
        checkReceiptsButton = new MenuButton(0, 50, 200, 40, "RECEIPTS");
        checkReceiptsButton.addActionListener(e -> {
            if (e.getSource() == checkReceiptsButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.RECEIPTS);
            }
        });

        this.add(checkReceiptsButton);
    }

    private void setPrepareMealButton() {
        prepareMealButton = new MenuButton(0, 100, 200, 40, "PREPARE MEAL");
        prepareMealButton.addActionListener(e -> {
            if (e.getSource() == prepareMealButton && menuButtonsListener != null){
                menuButtonsListener.buttonClicked(MenuButtonsActions.PREPARE_MENU);
            }
        });

        this.add(prepareMealButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }
}
