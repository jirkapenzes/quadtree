package com.jpenzes.ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:55 PM
 */
public class MenuPanel extends JPanel {

    private final JButton startButton;
    private final JButton pauseButton;
    private final JButton clearButton;
    private final JCheckBox gridCheckbox;
    private final JCheckBox colorCheckbox;
    private final JComboBox<Object> sceneComboBox;
    private final JRadioButton speedFastRadioButton;
    private final JRadioButton speedSlowRadioButton;

    public MenuPanel(HashMap<String, Object> uiParameters) {
        startButton = new JButton(this.<String>get(uiParameters, "startButton.label"));
        pauseButton = new JButton(this.<String>get(uiParameters, "pauseButton.label"));
        clearButton = new JButton(this.<String>get(uiParameters, "clearButton.label"));
        gridCheckbox = new JCheckBox(this.<String>get(uiParameters, "gridCheckbox.label"));
        colorCheckbox = new JCheckBox(this.<String>get(uiParameters, "colorCheckbox.label"));
        sceneComboBox = new JComboBox<>(this.<String[]>get(uiParameters, "sceneComboBox.values"));
        speedFastRadioButton = new JRadioButton(this.<String>get(uiParameters, "speedFastRadioButton.label"));
        speedSlowRadioButton = new JRadioButton(this.<String>get(uiParameters, "speedSlowRadioButton.label"));

        initializeUI();
    }

    private <T> T get(HashMap<String, Object> uiParameters, String key) {
        if (!uiParameters.containsKey(key)) {
            throw new RuntimeException("UI parameter not found: " + key);
        }
        return (T) uiParameters.get(key);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1024, 50);
    }

    private void initializeUI() {
        gridCheckbox.setForeground(new Color(187, 187, 187));
        colorCheckbox.setForeground(new Color(187, 187, 187));
        speedFastRadioButton.setForeground(new Color(187, 187, 187));
        speedSlowRadioButton.setForeground(new Color(187, 187, 187));

        setBackground(new Color(57, 61, 63));
        setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(39, 41, 42)));
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        ButtonGroup speedRadioButtonGroup = new ButtonGroup();
        speedRadioButtonGroup.add(speedFastRadioButton);
        speedRadioButtonGroup.add(speedSlowRadioButton);

        add(startButton);
        add(pauseButton);
        add(clearButton);
        add(sceneComboBox);
        add(gridCheckbox);
        add(colorCheckbox);
        add(speedFastRadioButton);
        add(speedSlowRadioButton);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(new Color(37, 39, 40));
        graphics.drawLine(0, 1, getWidth(), 1);
        graphics.setColor(new Color(81, 83, 85));
        graphics.drawLine(0, 2, getWidth(), 2);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JCheckBox getGridCheckbox() {
        return gridCheckbox;
    }

    public JCheckBox getColorCheckbox() {
        return colorCheckbox;
    }

    public JComboBox<Object> getSceneComboBox() {
        return sceneComboBox;
    }

    public JRadioButton getSpeedFastRadioButton() {
        return speedFastRadioButton;
    }

    public JRadioButton getSpeedSlowRadioButton() {
        return speedSlowRadioButton;
    }
}
