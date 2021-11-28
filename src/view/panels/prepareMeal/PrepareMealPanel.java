package view.panels.prepareMeal;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.listeners.PrepareMealListener;
import view.panels.PanelsColor;

import javax.swing.*;

public class PrepareMealPanel extends JPanel {
    private final PrepareMealSplitPane splitPane;
    private static MenuButtonsListener menuButtonsListener;
    private static PrepareMealListener prepareMealListener;
    private MenuButton goToMenuButton;
    private MenuButton prepareMealButton;

    public PrepareMealPanel() {
        splitPane = new PrepareMealSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(PanelsColor.PANEL_COLOR);

        splitPane.setBounds(0, 0, 790, 550);
        this.add(splitPane);

        setGoToMenuButton();
        setPrepareMealButton();
    }

    public void refreshSize() {
        this.setBounds(0, 0, 800, 670);
    }

    private void setGoToMenuButton() {
        goToMenuButton = new MenuButton(20, 570, 200, 40, "GO BACK");
        goToMenuButton.addActionListener(e -> {
            if (e.getSource() == goToMenuButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goToMenuButton);
    }

    private void setPrepareMealButton() {
        prepareMealButton = new MenuButton(565, 570, 200, 40, "PREPARE MEAL");
        prepareMealButton.addActionListener(e -> {
            if (e.getSource() == prepareMealButton
                    && menuButtonsListener != null
                    && splitPane.getReceiptToPrepare() != null) {
                prepareMealListener.prepare(splitPane.getReceiptToPrepare());
            }
        });

        this.add(prepareMealButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        PrepareMealPanel.menuButtonsListener = menuButtonsListener;
    }

    public void setPrepareMealListener(PrepareMealListener prepareMealListener) {
        PrepareMealPanel.prepareMealListener = prepareMealListener;
        splitPane.setPrepareMealListener(prepareMealListener);
    }

    public PrepareMealSplitPane getSplitPane() {
        return splitPane;
    }

    public MenuButton getPrepareMealButton() {
        return prepareMealButton;
    }
}
