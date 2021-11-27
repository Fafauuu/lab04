package view.panels.prepareMeal;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.listeners.PrepareMealListener;

import javax.swing.*;
import java.awt.*;

public class PrepareMealPanel extends JPanel {
    private final PrepareMealSplitPane splitPane;
    private MenuButtonsListener menuButtonsListener;
    private PrepareMealListener prepareMealListener;
    private MenuButton goToMenuButton;

    public PrepareMealPanel() {
        splitPane = new PrepareMealSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(Color.pink);

        splitPane.setBounds(0,0,790,380);
        this.add(splitPane);

        setGoToMenuButton();
    }

    public void refreshSize() {
        this.setBounds(0,0,800,500);
    }

    private void setGoToMenuButton() {
        goToMenuButton = new MenuButton(20, 400, 200, 40, "GO BACK");
        goToMenuButton.setEnabled(true);

        goToMenuButton.addActionListener(e -> {
            if (e.getSource() == goToMenuButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goToMenuButton);
    }

    public PrepareMealSplitPane getSplitPane() {
        return splitPane;
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }

    public void setPrepareMealListener(PrepareMealListener prepareMealListener) {
        this.prepareMealListener = prepareMealListener;
        splitPane.setPrepareMealListener(prepareMealListener);
    }
}
