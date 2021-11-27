package view.panels.receipts;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class ReceiptsPanel extends JPanel {
    private final ReceiptSplitPane splitPane;
    private MenuButtonsListener menuButtonsListener;
    private MenuButton goBackButton;

    public ReceiptsPanel() {
        splitPane = new ReceiptSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(Color.ORANGE);

        splitPane.setBounds(0,0,490,380);
        this.add(splitPane);

        setGoBackButton();
    }

    public void refreshSize() {
        this.setBounds(0, 0, 500, 500);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 400, 200, 40, "GO BACK");
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

    public ReceiptSplitPane getSplitPane() {
        return splitPane;
    }
}
