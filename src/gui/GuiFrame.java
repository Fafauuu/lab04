package gui;

import javax.swing.*;
import java.awt.*;

public class GuiFrame{
    private JPanel panel1;
    private JButton button1;
    private JTextPane textPane1;

    public GuiFrame() {
        var frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000,300);

        panel1.setSize(1000,300);
        panel1.setVisible(true);

        button1.addActionListener(e -> {
            textPane1.setText(textPane1.getText() + "*");
        });

        frame.add(panel1);
        frame.setVisible(true);
    }
}
