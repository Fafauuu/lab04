package view.panels.ingredients;

import view.components.MenuButton;
import view.listeners.AddIngredientListener;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddIngredientPanel extends JPanel {
    private MenuButtonsListener menuButtonsListener;
    private AddIngredientListener addIngredientListener;
    private MenuButton goBackButton;
    private MenuButton saveButton;
    private JTextField nameField;
    private JTextField amountField;

    public AddIngredientPanel() {
        this.setLayout(null);
        this.setBackground(Color.CYAN);

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
        saveButton.addActionListener(e -> {
            if (e.getSource() == saveButton && addIngredientListener != null) {
//                addIngredientListener.addIngredient();
            }
        });

        this.add(saveButton);
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        this.menuButtonsListener = menuButtonsListener;
    }

    public void setAddIngredientListener(AddIngredientListener addIngredientListener) {
        this.addIngredientListener = addIngredientListener;
    }
}
