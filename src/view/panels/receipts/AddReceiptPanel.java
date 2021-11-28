package view.panels.receipts;

import view.components.MenuButton;
import view.listeners.AddReceiptListener;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddReceiptPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
    private AddReceiptListener addReceiptListener;
    private MenuButton goBackButton;
    private MenuButton saveButton;
    private JTextField nameField;
    private JTextArea descriptionArea;

    public AddReceiptPanel() {
        this.setLayout(null);
        this.setBackground(Color.ORANGE);

        setNameField();
        setDescriptionArea();
        setGoBackButton();
        setSaveButton();

        refresh();
    }

    public void refresh() {
        this.setBounds(0, 0, 400, 401);
        this.remove(nameField);
        setNameField();
        this.remove(descriptionArea);
        setDescriptionArea();
    }

    private void setNameField() {
        nameField = new JTextField();
        nameField.setBounds(20, 20, 350, 40);
        nameField.setText("name");
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(nameField);
    }

    private void setDescriptionArea() {
        descriptionArea = new JTextArea();
        descriptionArea.setBounds(20,80,350,100);
        descriptionArea.setText("description");
        descriptionArea.setLineWrap(true);
        descriptionArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                descriptionArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(descriptionArea);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 300, 150, 40, "GO BACK");
        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.RECEIPTS);
            }
        });

        this.add(goBackButton);
    }

    private void setSaveButton() {
        saveButton = new MenuButton(215, 300, 150, 40, "SAVE");
        saveButton.addActionListener(e -> {
            if (e.getSource() == saveButton && addReceiptListener != null) {
//                addReceiptListener.addReceipt();
            }
        });

        this.add(saveButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }

    public void setAddReceiptListener(AddReceiptListener addReceiptListener) {
        this.addReceiptListener = addReceiptListener;
    }
}
