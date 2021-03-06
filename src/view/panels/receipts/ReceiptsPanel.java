package view.panels.receipts;

import view.components.MenuButton;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.panels.PanelsColor;

import javax.swing.*;

public class ReceiptsPanel extends JPanel {
    private final ReceiptSplitPane splitPane;
    private static MenuButtonsListener menuButtonsListener;
    private MenuButton goBackButton;
    private MenuButton addReceiptButton;
    private MenuButton editReceiptButton;

    public ReceiptsPanel() {
        splitPane = new ReceiptSplitPane();
        this.setLayout(null);
        refreshSize();
        this.setBackground(PanelsColor.PANEL_COLOR);

        splitPane.setBounds(0,0,490,380);
        this.add(splitPane);

        setGoBackButton();
        setAddReceiptButton();
        setEditReceiptButton();
    }

    public void refreshSize() {
        this.setBounds(0, 0, 500, 560);
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

    private void setEditReceiptButton() {
        editReceiptButton = new MenuButton(145, 465, 200, 40, "EDIT RECEIPT");
        editReceiptButton.addActionListener(e -> {
            if (e.getSource() == editReceiptButton && menuButtonsListener != null && splitPane.getChosenReceipt() != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.EDIT_RECEIPT);
            }
        });

        this.add(editReceiptButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        ReceiptsPanel.menuButtonsListener = menuButtonsListener;
    }

    public ReceiptSplitPane getSplitPane() {
        return splitPane;
    }
}
