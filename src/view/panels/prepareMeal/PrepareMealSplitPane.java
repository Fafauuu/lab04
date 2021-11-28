package view.panels.prepareMeal;

import dataBase.Database;
import model.Receipt;
import view.listeners.PrepareMealListener;

import javax.swing.*;
import java.awt.*;

public class PrepareMealSplitPane extends JSplitPane {
    private final JList<Receipt> list = new JList<>();
    private final DefaultListModel<Receipt> model = new DefaultListModel<>();
    private final GraphPanel graphPanel = new GraphPanel();
    private static PrepareMealListener prepareMealListener;
    private Receipt receiptToPrepare;

    public PrepareMealSplitPane() {
        list.setModel(model);

        model.addAll(Database.getInstance().getReceipts());
        list.setFont(new Font("Arial", Font.BOLD,20));

        list.getSelectionModel().addListSelectionListener(e -> {
            Receipt receiptChosen = list.getSelectedValue();
            if (prepareMealListener != null && !e.getValueIsAdjusting()){
                prepareMealListener.preparationReview(receiptChosen);
                receiptToPrepare = receiptChosen;
            }
        });
        this.setLeftComponent(new JScrollPane(list));
        this.setRightComponent(graphPanel);
    }

    public Receipt getReceiptToPrepare() {
        return receiptToPrepare;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }

    public void setPrepareMealListener(PrepareMealListener prepareMealListener) {
        PrepareMealSplitPane.prepareMealListener = prepareMealListener;
    }
}
