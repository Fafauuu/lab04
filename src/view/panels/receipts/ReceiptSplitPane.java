package view.panels.receipts;

import dataBase.Database;
import model.Receipt;
import view.listeners.ReceiptListListener;

import javax.swing.*;
import java.awt.*;

public class ReceiptSplitPane extends JSplitPane{
    private final JList<Receipt> list = new JList<>();
    private final DefaultListModel<Receipt> model = new DefaultListModel<>();
    private final JLabel descriptionTitle = new JLabel();
    private final JLabel descriptionLabel = new JLabel();
    private final JLabel ingredientsTitle = new JLabel();
    private final JLabel ingredientsLabel = new JLabel();
    private final JPanel panel = new JPanel();
    private static ReceiptListListener receiptListListener;

    public ReceiptSplitPane() {
        list.setModel(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.addAll(Database.getInstance().getReceipts());
        list.setFont(new Font("Arial", Font.BOLD,20));

        list.getSelectionModel().addListSelectionListener(e -> {
            Receipt receiptChosen = list.getSelectedValue();
            if (receiptListListener != null && !e.getValueIsAdjusting()){
                receiptListListener.ReceiptChosen(receiptChosen);
            }
        });

        this.setLeftComponent(new JScrollPane(list));
        panel.setLayout(null);
        setLabels();
        this.setRightComponent(panel);
    }

    private void setLabels() {
        setDescriptionTitleLabel();
        setDescriptionLabel();
        setIngredientsTitleLabel();
        setIngredientsLabel();
    }

    private void setDescriptionTitleLabel() {
        descriptionTitle.setBounds(5,0,200,30);
        descriptionTitle.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(descriptionTitle);
    }

    private void setDescriptionLabel() {
        descriptionLabel.setVerticalAlignment(JLabel.TOP);
        descriptionLabel.setBounds(5,30,330,200);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN,18));
        panel.add(descriptionLabel);
    }

    private void setIngredientsTitleLabel() {
        ingredientsTitle.setBounds(5,130,200,30);
        ingredientsTitle.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(ingredientsTitle);
    }

    private void setIngredientsLabel() {
        ingredientsLabel.setVerticalAlignment(JLabel.TOP);
        ingredientsLabel.setBounds(5,160,330,200);
        ingredientsLabel.setFont(new Font("Arial", Font.PLAIN,18));
        panel.add(ingredientsLabel);
    }

    public void setReceiptListListener(ReceiptListListener ingredientListListener) {
        receiptListListener = ingredientListListener;
    }

    public JLabel getDescriptionTitle() {
        return descriptionTitle;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JLabel getIngredientsTitle() {
        return ingredientsTitle;
    }

    public JLabel getIngredientsLabel() {
        return ingredientsLabel;
    }

    public Receipt getChosenReceipt(){
        return list.getSelectedValue();
    }
}
