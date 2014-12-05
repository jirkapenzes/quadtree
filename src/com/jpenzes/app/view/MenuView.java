package com.jpenzes.app.view;

import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.smawing.SFrame;
import com.jpenzes.smawing.SView;
import com.jpenzes.ui.MenuPanel;

import javax.swing.*;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:45 PM
 */
public class MenuView extends SView<MenuModel> {

    private MenuPanel menuPanel;

    public MenuView(SFrame frame, Class<MenuModel> modelClassName) {
        super(frame, modelClassName);
    }

    @Override
    protected JComponent layout() {
        if (menuPanel == null)
            menuPanel = new MenuPanel(getModel().getUiLabels());

        updateView();
        return menuPanel;
    }

    public JButton getStartButton() {
        return menuPanel.getStartButton();
    }

    public JButton getPauseButton() {
        return menuPanel.getPauseButton();
    }

    public JButton getClearButton() {
        return menuPanel.getClearButton();
    }

    public JCheckBox getGridCheckbox() {
        return menuPanel.getGridCheckbox();
    }

    public JCheckBox getColorCheckbox() {
        return menuPanel.getColorCheckbox();
    }

    public JComboBox<Object> getSceneComboBox() {
        return menuPanel.getSceneComboBox();
    }

    public JRadioButton getSpeedSlowRadioButton() {
        return menuPanel.getSpeedSlowRadioButton();
    }

    public JRadioButton getSpeedFastRadioButton() {
        return menuPanel.getSpeedFastRadioButton();
    }

    @Override
    public void updateView() {
        getGridCheckbox().setSelected(getModel().isGrid());
        getColorCheckbox().setSelected(getModel().isCellBackgroundColor());
        getSpeedFastRadioButton().setSelected(getMainFrame().getModel(QuadTreeModel.class).getSpeed() == QuadTreeModel.SpeedFast);
        getSpeedSlowRadioButton().setSelected(getMainFrame().getModel(QuadTreeModel.class).getSpeed() == QuadTreeModel.SpeedSlow);
    }
}
