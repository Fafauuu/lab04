package view.frames;

import view.panels.ingredients.IngredientsPanel;
import view.panels.mainMenu.MainMenuPanel;
import view.panels.receipts.ReceiptsPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel activePanel;
    private final MainMenuPanel mainMenuPanel;
    private final IngredientsPanel ingredientsPanel;
    private final ReceiptsPanel receiptsPanel;

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.mainMenuPanel = new MainMenuPanel();
        this.ingredientsPanel = new IngredientsPanel();
        this.receiptsPanel = new ReceiptsPanel();
        setActivePanel(mainMenuPanel);
    }

    public void setActivePanel(JPanel panel) {
        if (activePanel != null){
            this.remove(activePanel);
            mainMenuPanel.setBounds(0,0,420,420);
            ingredientsPanel.setBounds(0,0,800,800);
            receiptsPanel.setBounds(0,0,800,800);
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
}
