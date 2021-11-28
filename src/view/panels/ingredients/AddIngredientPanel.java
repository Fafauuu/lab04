package view.panels.ingredients;

import view.components.MenuButton;
import view.listeners.AddIngredientListener;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.panels.PanelsColor;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddIngredientPanel extends JPanel {
    private static MenuButtonsListener menuButtonsListener;
    private static AddIngredientListener addIngredientListener;
    private MenuButton goBackButton;
    private MenuButton saveButton;
    private JTextField nameField;
    private JTextField amountField;
    private boolean nameFilled = false;
    private boolean amountFilled = false;

    public AddIngredientPanel() {
        this.setLayout(null);
        this.setBackground(PanelsColor.PANEL_COLOR);

        setNameField();
        setAmountField();
        setGoBackButton();
        setSaveButton();
        refresh();
    }

    public void refresh() {
        this.setBounds(0, 0, 400, 401);
        this.remove(nameField);
        setNameField();
        this.remove(amountField);
        setAmountField();
    }

    private void setNameField() {
        nameField = new JTextField();
        nameField.setBounds(20, 20, 350, 40);
        nameField.setText("name");
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.setText("");
                nameFilled = true;
                enableSaveButton();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(nameField);
    }

    private void setAmountField() {
        amountField = new JTextField();
        amountField.setBounds(20, 80, 350, 40);
        amountField.setText("amount");
        amountField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                amountField.setText("");
                amountFilled = true;
                enableSaveButton();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(amountField);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 300, 150, 40, "GO BACK");
        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.INGREDIENTS);
            }
        });

        this.add(goBackButton);
    }

    private void setSaveButton() {
        saveButton = new MenuButton(215, 300, 150, 40, "SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(e -> {
            if (e.getSource() == saveButton && addIngredientListener != null) {
                addIngredientListener.addIngredient(nameField.getText(), Integer.valueOf(amountField.getText()));
                this.remove(nameField);
                setNameField();
                this.remove(amountField);
                setAmountField();
                saveButton.setEnabled(false);
            }
        });

        this.add(saveButton);
    }

    private void enableSaveButton() {
        if (nameFilled && amountFilled) {
            saveButton.setEnabled(true);
        }
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        AddIngredientPanel.menuButtonsListener = menuButtonsListener;
    }

    public void setAddIngredientListener(AddIngredientListener addIngredientListener) {
        AddIngredientPanel.addIngredientListener = addIngredientListener;
    }
}
