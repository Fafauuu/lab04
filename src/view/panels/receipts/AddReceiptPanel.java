package view.panels.receipts;

import dataBase.Database;
import model.Ingredient;
import model.Receipt;
import view.components.MenuButton;
import view.listeners.AddReceiptListener;
import view.listeners.MenuButtonsActions;
import view.listeners.MenuButtonsListener;
import view.panels.PanelsColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

public class AddReceiptPanel extends JPanel {
    private static MenuButtonsListener menuButtonsListener;
    private static AddReceiptListener addReceiptListener;
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextArea ingredientsChosenArea;
    private JTextField addAmountField;
    private JButton addIngredientButton;
    private final JList<Ingredient> ingredientsList = new JList<>();
    private final DefaultListModel<Ingredient> model = new DefaultListModel<>();
    private MenuButton goBackButton;
    private MenuButton saveButton;
    private Map<Integer, Integer> ingredientsChosen;
    private boolean nameFilled = false;
    private boolean descriptionFilled = false;
    private boolean ingredientsFilled = false;

    public AddReceiptPanel() {
        this.setLayout(null);
        this.setBackground(PanelsColor.PANEL_COLOR);
        ingredientsChosen = new HashMap<>();

        setNameField();
        setDescriptionArea();
        setIngredientsChosenArea();
        setIngredientsList();
        setAddAmountField();
        setAddIngredientButton();
        setGoBackButton();
        setSaveButton();

        refresh();
    }

    private void setAddAmountField() {
        addAmountField = new JTextField();
        addAmountField.setBounds(350, 300, 100, 40);
        addAmountField.setText("amount");
        addAmountField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                addIngredientButton.setEnabled(true);
                addAmountField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(addAmountField);
    }

    private void setAddIngredientButton() {
        addIngredientButton = new MenuButton(470, 300, 100, 40, "ADD");
        addIngredientButton.setEnabled(false);
        addIngredientButton.addActionListener(e -> {
            if (e.getSource() == addIngredientButton) {
                ingredientsChosen.put(ingredientsList.getSelectedValue().getId(),
                        Integer.parseInt(addAmountField.getText()));

                refreshIngredientsDescription();
                addAmountField.setText("amount");
                addIngredientButton.setEnabled(false);
                ingredientsFilled = true;
                enableSaveButton();
            }
        });

        this.add(addIngredientButton);
    }

    public void refresh() {
        this.setBounds(0, 0, 600, 501);
        this.remove(nameField);
        setNameField();
        this.remove(descriptionArea);
        setDescriptionArea();
    }

    private void setNameField() {
        nameField = new JTextField();
        nameField.setBounds(20, 20, 300, 40);
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

    private void setDescriptionArea() {
        descriptionArea = new JTextArea();
        descriptionArea.setBounds(20,80,300,100);
        descriptionArea.setText("description");
        descriptionArea.setLineWrap(true);
        descriptionArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                descriptionArea.setText("");
                descriptionFilled = true;
                enableSaveButton();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.add(descriptionArea);
    }

    private void setIngredientsChosenArea() {
        ingredientsChosenArea = new JTextArea();
        ingredientsChosenArea.setBounds(20,200,300,180);
        descriptionArea.setLineWrap(true);
        refreshIngredientsDescription();
        this.add(ingredientsChosenArea);
    }

    private void refreshIngredientsDescription() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Integer ingredientId : ingredientsChosen.keySet()) {
            sb.append(count++);
            sb.append(". ");
            sb.append(Database.getInstance().getIngredient(ingredientId));
            sb.append(" : ");
            sb.append(ingredientsChosen.get(ingredientId));
            sb.append("\n");
        }
        System.out.println(sb);
        ingredientsChosenArea.setText(sb.toString());
    }

    private void setIngredientsList() {
        ingredientsList.setModel(model);

        model.addAll(Database.getInstance().getIngredients());
        ingredientsList.setFont(new Font("Arial", Font.BOLD,20));
        ingredientsList.setBounds(0,0,210,260);

        ingredientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jScrollPane = new JScrollPane(ingredientsList);
        jScrollPane.setBounds(350,20,210,260);

        this.add(jScrollPane);
    }

    private void setGoBackButton() {
        goBackButton = new MenuButton(20, 400, 200, 40, "GO BACK");
        goBackButton.addActionListener(e -> {
            if (e.getSource() == goBackButton && menuButtonsListener != null) {
                menuButtonsListener.buttonClicked(MenuButtonsActions.RECEIPTS);
                ingredientsChosen.clear();
            }
        });

        this.add(goBackButton);
    }

    private void setSaveButton() {
        saveButton = new MenuButton(355, 400, 200, 40, "SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(e -> {
            if (e.getSource() == saveButton && addReceiptListener != null) {
                Receipt receipt = new Receipt(nameField.getText());
                receipt.setDescription(descriptionArea.getText());
                Map<Integer, Integer> ingredients = new HashMap<>();
                for (Integer ingredientID : ingredientsChosen.keySet()) {
                    ingredients.put(ingredientID, ingredientsChosen.get(ingredientID));
                }
                receipt.setIngredients(ingredients);
                addReceiptListener.addReceipt(receipt);
                refreshIngredientsDescription();
                remove(nameField);
                setNameField();
            }
        });

        this.add(saveButton);
    }

    private void enableSaveButton(){
        if (nameFilled && descriptionFilled && ingredientsFilled){
            saveButton.setEnabled(true);
        }
    }

    public void setMenuButtonsListener(MenuButtonsListener menuButtonsListener) {
        AddReceiptPanel.menuButtonsListener = menuButtonsListener;
    }

    public void setAddReceiptListener(AddReceiptListener addReceiptListener) {
        AddReceiptPanel.addReceiptListener = addReceiptListener;
    }
}
