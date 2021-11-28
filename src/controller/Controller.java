package controller;

import dataBase.Database;
import model.Ingredient;
import model.Receipt;
import view.frames.MainFrame;
import view.listeners.*;
import view.panels.prepareMeal.GraphPanel;

import java.util.HashMap;
import java.util.Map;

public class Controller implements
        MenuButtonsListener,
        IngredientListListener,
        ReceiptListListener,
        PrepareMealListener,
        AddIngredientListener,
        AddReceiptListener {
    private final MainFrame mainFrame;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void buttonClicked(MenuButtonsActions action) {
        System.out.println(action + " action performed");
        if (MenuButtonsActions.INGREDIENTS.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getIngredientsPanel());
        }
        else if (MenuButtonsActions.MAIN_MENU.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getMainMenuPanel());
        }
        else if (MenuButtonsActions.RECEIPTS.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getReceiptsPanel());
        }
        else if (MenuButtonsActions.PREPARE_MENU.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getPrepareMealPanel());
        }
        else if (MenuButtonsActions.ADD_INGREDIENT.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getAddIngredientPanel());
        }
        else if (MenuButtonsActions.ADD_RECEIPT.equals(action)){
            mainFrame.setActivePanel(mainFrame.getAddReceiptPanel());
        }

    }

    @Override
    public void IngredientChosen(Ingredient ingredient) {
        System.out.println(ingredient + " ingredient chosen");
        mainFrame.getIngredientsPanel().getSplitPane().getAmountLabel()
                .setText("Amount: " + ingredient.getQuantity());
    }

    @Override
    public void ReceiptChosen(Receipt receipt) {
        System.out.println(receipt + " receipt chosen");
        mainFrame.getReceiptsPanel().getSplitPane().getDescriptionTitle().setText("Description");
        mainFrame.getReceiptsPanel().getSplitPane().getDescriptionLabel()
                .setText("<html>" + receipt.getDescription() + "</html>");
        mainFrame.getReceiptsPanel().getSplitPane().getIngredientsTitle().setText("Ingredients");
        mainFrame.getReceiptsPanel().getSplitPane().getIngredientsLabel()
                .setText("<html>" + toStringIngredients(receipt) + "</html>");
    }

    private String toStringIngredients(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        for (Integer ingredientID : receipt.getIngredients().keySet()) {
            Ingredient ingredient = Database.getInstance().getIngredient(ingredientID);
            sb.append(ingredient.getName());
            sb.append(": ");
            sb.append(receipt.getIngredients().get(ingredientID));
            sb.append("<br>");
        }
        return sb.toString();
    }

    @Override
    public void preparationReview(Receipt receipt) {
        System.out.println("PrepareReview: " + receipt);
        GraphPanel graphPanel = mainFrame.getPrepareMealPanel().getSplitPane().getGraphPanel();
        Map<Integer, Integer> updatedIngredientAmount = new HashMap<>();
        boolean executable = true;

        for (Ingredient ingredient : Database.getInstance().getIngredients()) {
            int updatedAmount;
            if (receipt.getIngredients().containsKey(ingredient.getId())){
                updatedAmount = Database.getInstance().getIngredient(ingredient.getId()).getQuantity()
                        - receipt.getIngredients().get(ingredient.getId());
            }
            else updatedAmount = ingredient.getQuantity();
            updatedIngredientAmount.put(ingredient.getId(), updatedAmount);
            if (updatedAmount < 0) executable = false;
        }

        if (!executable){
            mainFrame.getPrepareMealPanel().getPrepareMealButton().setEnabled(false);
        } else mainFrame.getPrepareMealPanel().getPrepareMealButton().setEnabled(true);

        graphPanel.setUpdatedIngredientAmount(updatedIngredientAmount);
        graphPanel.repaint();
    }

    @Override
    public void prepare(Receipt receiptToPrepare) {
        System.out.println("Prepare: " + receiptToPrepare);
        for (Integer ingredientID : receiptToPrepare.getIngredients().keySet()) {
            Database.getInstance().getIngredient(ingredientID)
                    .reduceAmount(receiptToPrepare.getIngredients().get(ingredientID));
        }
        mainFrame.getPrepareMealPanel().getSplitPane().getGraphPanel().repaint();
    }

    @Override
    public void addIngredient(String name, Integer amount) {
        System.out.println("Add: " + name);
        Database.getInstance().addIngredient(name, amount);
        mainFrame.refreshPanels();
    }

    @Override
    public void addReceipt(Receipt receipt) {
        System.out.println("Add: " + receipt);
        Database.getInstance().addReceipt(receipt);
        mainFrame.refreshPanels();
    }
}
