package view.panels.prepareMeal;

import dataBase.Database;
import model.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GraphPanel extends JPanel {
    private final List<Ingredient> ingredients;
    private Map<Integer, Integer> updatedIngredientAmount;

    public GraphPanel() {
        this.ingredients = Database.getInstance().getIngredients();
        this.setLayout(null);
        this.setBackground(new Color(0xD0D0D0));
    }

    public void setUpdatedIngredientAmount(Map<Integer, Integer> updatedIngredientAmount) {
        this.updatedIngredientAmount = updatedIngredientAmount;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(0x000000));
        for (int i = 1; i < 6; i++) {
            g.drawLine(0, 100 * i, 790, 100 * i);
            g.drawString(Integer.toString(50 - 10 * i), 3, 100 * i - 5);
        }

        for (int i = 0; i < ingredients.size(); i++) {
            int y = 10 * (50 - ingredients.get(i).getQuantity());
            g.setFont(new Font("Arial", Font.PLAIN, 11));
            g.drawString(ingredients.get(i).toString(), i * 60 + 50, y - 7);
        }

        g.setColor(new Color(0xBAFF52));

        for (int i = 0; i < ingredients.size(); i++) {
            int y = 10 * (50 - ingredients.get(i).getQuantity());
            g.fillRect(i * 60 + 50, y, 50, 500 - y);
        }

        if (updatedIngredientAmount != null) {
            g.setColor(new Color(0xFF1616));

            for (int i = 0; i < ingredients.size(); i++) {
                int y = 10 * (50 - ingredients.get(i).getQuantity());
                g.fillRect(i * 60 + 50, y, 50, 500 - y);
            }

            g.setColor(new Color(0xBAFF52));

            for (Integer ingredientID : updatedIngredientAmount.keySet()) {
                int y = 10 * (50 - updatedIngredientAmount.get(ingredientID));
                if (updatedIngredientAmount.get(ingredientID) < 0) {
                    g.setColor(new Color(0xFDAF39));
                    g.fillRect(ingredientID * 60 + 50, y, 50, 500 - y);
                    g.setColor(new Color(0xBAFF52));
                } else g.fillRect(ingredientID * 60 + 50, y, 50, 500 - y);
            }
        }
    }

}
