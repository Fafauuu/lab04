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
    private MenuButton addReceiptButton;

    public ReceiptsPanel() {
        splitPane = new ReceiptSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(Color.ORANGE);

        splitPane.setBounds(0,0,490,380);
        this.add(splitPane);

        setGoBackButton();
        setAddReceiptButton();
    }

    public void refreshSize() {
        this.setBounds(0, 0, 500, 500);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 400, 200, 40, "GO BACK");
        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.MAIN_MENU);
            }
        });

        this.add(goBackButton);
    }

    private void setAddReceiptButton() {
        addReceiptButton = new MenuButton(265, 400, 200, 40, "ADD RECEIPT");
        addReceiptButton.addActionListener(e -> {
            if (e.getSource() == addReceiptButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.ADD_RECEIPT);
            }
        });

        this.add(addReceiptButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }

    public ReceiptSplitPane getSplitPane() {
        return splitPane;
    }
}
