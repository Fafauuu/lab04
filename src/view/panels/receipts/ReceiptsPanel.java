package view.panels.receipts;

import view.components.MenuButton;
import view.panels.listeners.MenuButtonsActions;
import view.panels.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;

public class ReceiptsPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
    private ReceiptsPanelListener receiptsPanelListener;
    private MenuButton goBackButton;

    public ReceiptsPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setBackground(Color.ORANGE);

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

    public void setReceiptsPanelListener(ReceiptsPanelListener receiptsPanelListener) {
        this.receiptsPanelListener = receiptsPanelListener;
    }
}
