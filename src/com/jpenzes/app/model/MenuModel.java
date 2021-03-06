package com.jpenzes.app.model;

import com.jpenzes.smawing.SModel;

import java.util.HashMap;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:45 PM
 */
public class MenuModel extends SModel {

    private HashMap<String, Object> uiLabels;
    private boolean isGrid;
    private boolean isCellBackgroundColor;

    public static String OnlyBalls = "Only balls";
    public static String GameOfLifeRandom = "Game of life";
    public static String Collisions = "Collisions";
    public static String Simple = "Simple collisions";
    public static String GunCellularAutomaton = "Gun Cellular Automaton";

    public MenuModel() {
        uiLabels = new HashMap<>();
        getUiLabels().put("startButton.label", "Start");
        getUiLabels().put("pauseButton.label", "Pause");
        getUiLabels().put("clearButton.label", "Clear");
        getUiLabels().put("gridCheckbox.label", "Show grid");
        getUiLabels().put("colorCheckbox.label", "Show color");
        getUiLabels().put("sceneComboBox.values", new String[]{OnlyBalls, Collisions, Simple, GameOfLifeRandom, GunCellularAutomaton});
        getUiLabels().put("speedFastRadioButton.label", "Speed fast");
        getUiLabels().put("speedSlowRadioButton.label", "Speed slow");

        setGrid(false);
        setCellBackgroundColor(true);
    }

    public HashMap<String, Object> getUiLabels() {
        return uiLabels;
    }

    public boolean isGrid() {
        return isGrid;
    }

    public void setGrid(boolean isGrid) {
        this.isGrid = isGrid;
        requestNotify();
    }

    public boolean isCellBackgroundColor() {
        return isCellBackgroundColor;
    }

    public void setCellBackgroundColor(boolean isCellBackgroundColor) {
        this.isCellBackgroundColor = isCellBackgroundColor;
        requestNotify();
    }
}
