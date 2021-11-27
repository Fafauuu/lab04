package view.frames;

import view.panels.ingredients.IngredientsPanel;
import view.panels.mainMenu.MainMenuPanel;
import view.panels.receipts.ReceiptsPanel;
import view.panels.prepareMeal.PrepareMealPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel activePanel;
    private final MainMenuPanel mainMenuPanel;
    private final IngredientsPanel ingredientsPanel;
    private final ReceiptsPanel receiptsPanel;
    private final PrepareMealPanel prepareMealPanel;

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.mainMenuPanel = new MainMenuPanel();
        this.ingredientsPanel = new IngredientsPanel();
        this.receiptsPanel = new ReceiptsPanel();
        this.prepareMealPanel = new PrepareMealPanel();
        setActivePanel(mainMenuPanel);
    }

    public void setActivePanel(JPanel panel) {
        if (activePanel != null){
            this.remove(activePanel);
            mainMenuPanel.refreshSize();
            ingredientsPanel.refreshSize();
            receiptsPanel.refreshSize();
            prepareMealPanel.refreshSize();
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
}
