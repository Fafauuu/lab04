package view.panels.ingredients;

import dataBase.Database;
import model.Ingredient;
import view.listeners.IngredientListListener;

import javax.swing.*;
import java.awt.*;

public class IngredientsSplitPane extends JSplitPane {
    private final JList<Ingredient> list = new JList<>();
    private final JLabel amountLabel = new JLabel();
    private static IngredientListListener ingredientListListener;

    public IngredientsSplitPane() {
        DefaultListModel<Ingredient> model = new DefaultListModel<>();
        list.setModel(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addAll(Database.getInstance().getIngredients());
        list.setFont(new Font("Arial", Font.BOLD,20));

        list.getSelectionModel().addListSelectionListener(e -> {
            Ingredient ingredientChosen = list.getSelectedValue();
            if (ingredientListListener != null && !e.getValueIsAdjusting()){
                ingredientListListener.IngredientChosen(ingredientChosen);
            }
        });

        this.setLeftComponent(new JScrollPane(list));

        amountLabel.setFont(new Font("Arial", Font.PLAIN,18));

        JPanel panel = new JPanel();
        panel.add(amountLabel);

        this.setRightComponent(panel);
    }

    public void setIngredientListListener(IngredientListListener ingredientListListener) {
        IngredientsSplitPane.ingredientListListener = ingredientListListener;
    }

    public JLabel getAmountLabel() {
        return amountLabel;
    }
}
