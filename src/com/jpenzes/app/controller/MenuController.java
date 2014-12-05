package com.jpenzes.app.controller;

import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.app.view.MenuView;
import com.jpenzes.app.view.QuadTreeView;
import com.jpenzes.smawing.SController;
import com.jpenzes.smawing.SFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:44 PM
 */
public class MenuController extends SController<MenuView, MenuModel> {

    public MenuController(SFrame frame, Class<MenuView> view, Class<MenuModel> model) {
        super(frame, view, model);
    }

    @Override
    protected void initialize() {
        activateButtons(true, false, false);

        getView().getStartButton().addActionListener(e -> {
            getMainFrame().getController(QuadTreeController.class).actionStart();
            activateButtons(false, true, true);
        });

        getView().getPauseButton().addActionListener(e -> {
            getMainFrame().getController(QuadTreeController.class).actionPause();
            activateButtons(true, false, true);
        });

        getView().getClearButton().addActionListener(e -> {
            getMainFrame().getController(QuadTreeController.class).actionReset();
            activateButtons(true, true, true);
        });

        getView().getSceneComboBox().addActionListener(e -> {
            String selectedScene = getView().getSceneComboBox().getSelectedItem().toString();
            getMainFrame().getController(QuadTreeController.class).changeScene(selectedScene);
            activateButtons(true, false, false);
        });

        getView().getGridCheckbox().addActionListener(e -> {
            getModel().setGrid(getView().getGridCheckbox().isSelected());
            getMainFrame().getView(QuadTreeView.class).updateView();
        });

        getView().getColorCheckbox().addActionListener(e -> {
            getModel().setCellBackgroundColor(getView().getColorCheckbox().isSelected());
            getMainFrame().getView(QuadTreeView.class).updateView();
        });

        getView().getSpeedFastRadioButton().addActionListener(e -> {
            if (getView().getSpeedFastRadioButton().isSelected()) {
                changeSpeed(QuadTreeModel.SpeedFast);
            }
        });


        getView().getSpeedSlowRadioButton().addActionListener(e -> {
            if (getView().getSpeedSlowRadioButton().isSelected()) {
                changeSpeed(QuadTreeModel.SpeedSlow);
            }
        });
    }

    private void activateButtons(boolean start, boolean pause, boolean clear) {
        getView().getStartButton().setEnabled(start);
        getView().getPauseButton().setEnabled(pause);
        getView().getClearButton().setEnabled(clear);
    }

    private void changeSpeed(int speed) {
        getMainFrame().getModel(QuadTreeModel.class).setSpeed(speed);
        getMainFrame().getController(QuadTreeController.class).changeSpeed(speed);
    }
}
