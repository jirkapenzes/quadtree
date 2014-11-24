package com.jpenzes.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:55 PM
 */
public class MenuPanel extends JPanel {

    private final JButton startButton;

    public MenuPanel(String startButtonText) {
        startButton = new JButton(startButtonText);
        initializeUI();
    }

    private void initializeUI() {
        setBackground(new Color(92, 119, 132));
        setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(61, 64, 65)));
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(startButton);
    }

    public JButton getStartButton() {
        return startButton;
    }
}
