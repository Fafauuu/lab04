package view.panels.prepareMeal;

import dataBase.Database;
import model.Receipt;
import view.listeners.PrepareMealListener;

import javax.swing.*;
import java.awt.*;

public class PrepareMealSplitPane extends JSplitPane {
    private final JList<Receipt> list = new JList<>();
    private final DefaultListModel<Receipt> model = new DefaultListModel<>();
    private final JPanel panel = new JPanel();
    private PrepareMealListener prepareMealListener;

    public PrepareMealSplitPane() {
        list.setModel(model);

        model.addAll(Database.getInstance().getReceipts());
        list.setFont(new Font("Arial", Font.BOLD,20));

        list.getSelectionModel().addListSelectionListener(e -> {
            Receipt receiptChosen = list.getSelectedValue();
            if (prepareMealListener != null && !e.getValueIsAdjusting()){
                prepareMealListener.preparationReview(receiptChosen);
            }
        });
        this.setLeftComponent(new JScrollPane(list));
        panel.setLayout(null);
        this.setRightComponent(panel);
    }

    public void setPrepareMealListener(PrepareMealListener prepareMealListener) {
        this.prepareMealListener = prepareMealListener;
    }
}
