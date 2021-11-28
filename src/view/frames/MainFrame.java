package view.frames;

import view.panels.ingredients.AddIngredientPanel;
import view.panels.ingredients.IngredientsPanel;
import view.panels.mainMenu.MainMenuPanel;
import view.panels.receipts.AddReceiptPanel;
import view.panels.receipts.ReceiptsPanel;
import view.panels.prepareMeal.PrepareMealPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel activePanel;
    private MainMenuPanel mainMenuPanel;
    private IngredientsPanel ingredientsPanel;
    private ReceiptsPanel receiptsPanel;
    private PrepareMealPanel prepareMealPanel;
    private AddIngredientPanel addIngredientPanel;
    private AddReceiptPanel addReceiptPanel;

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        refreshPanels();
        setActivePanel(mainMenuPanel);
        this.setVisible(true);
    }

    public void refreshPanels() {
        this.mainMenuPanel = new MainMenuPanel();
        this.ingredientsPanel = new IngredientsPanel();
        this.receiptsPanel = new ReceiptsPanel();
        this.prepareMealPanel = new PrepareMealPanel();
        this.addIngredientPanel = new AddIngredientPanel();
        this.addReceiptPanel = new AddReceiptPanel();
    }

    public void setActivePanel(JPanel panel) {
        if (activePanel != null){
            this.remove(activePanel);
            mainMenuPanel.refreshSize();
            ingredientsPanel.refreshSize();
            receiptsPanel.refreshSize();
            prepareMealPanel.refreshSize();
            addIngredientPanel.refresh();
            addReceiptPanel.refresh();
        }
        this.activePanel = panel;
        this.setSize(panel.getWidth(), panel.getHeight());
        this.add(panel);
        this.setLocationRelativeTo(null);
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public IngredientsPanel getIngredientsPanel() {
        return ingredientsPanel;
    }

    public ReceiptsPanel getReceiptsPanel() {
        return receiptsPanel;
    }

    public PrepareMealPanel getPrepareMealPanel() {
        return prepareMealPanel;
    }

    public AddIngredientPanel getAddIngredientPanel() {
        return addIngredientPanel;
    }

    public AddReceiptPanel getAddReceiptPanel() {
        return addReceiptPanel;
    }
}
