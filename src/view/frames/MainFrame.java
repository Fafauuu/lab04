package view.frames;

import view.panels.ingredients.IngredientsPanel;
import view.panels.mainMenu.MainMenuPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel activePanel;
    private final MainMenuPanel mainMenuPanel;
    private final IngredientsPanel ingredientsPanel;

    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.mainMenuPanel = new MainMenuPanel();
        this.ingredientsPanel = new IngredientsPanel();
        setActivePanel(mainMenuPanel);
    }

    public void setActivePanel(JPanel panel) {
        if (activePanel != null){
            this.remove(activePanel);
        }
        this.activePanel = panel;
        this.setSize(panel.getSize());
        this.add(panel);
        this.setLocationRelativeTo(null);
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public IngredientsPanel getIngredientsPanel() {
        return ingredientsPanel;
    }
}
