package controller;

import dataBase.Database;
import model.Ingredient;
import model.Receipt;
import view.frames.MainFrame;
import view.listeners.*;

public class Controller implements
        MenuButtonsListener,
        IngredientListListener,
        ReceiptListListener,
        PrepareMealListener {
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
        if (MenuButtonsActions.MAIN_MENU.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getMainMenuPanel());
        }
        if (MenuButtonsActions.RECEIPTS.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getReceiptsPanel());
        }
        if (MenuButtonsActions.PREPARE_MENU.equals(action)) {
            mainFrame.setActivePanel(mainFrame.getPrepareMealPanel());
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
    }
}
