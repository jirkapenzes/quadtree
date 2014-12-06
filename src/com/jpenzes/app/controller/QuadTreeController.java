package com.jpenzes.app.controller;

import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.app.scenarious.collisions.BigScene;
import com.jpenzes.app.scenarious.collisions.SmallScene;
import com.jpenzes.app.scenarious.gol.GameOfLifeScene;
import com.jpenzes.app.util.BearInjector;
import com.jpenzes.app.view.QuadTreeView;
import com.jpenzes.smawing.SController;
import com.jpenzes.smawing.SFrame;
import com.jpenzes.tree.Rectangle;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:44 PM
 */
public class QuadTreeController extends SController<QuadTreeView, QuadTreeModel> {

    public QuadTreeController(SFrame frame, Class<QuadTreeView> view, Class<QuadTreeModel> model) {
        super(frame, view, model);
    }

    @Override
    protected void initialize() {
        getModel().getScene().initialize();
        new BearInjector(getView().getContentPane()).activate();
    }

    public void actionStart() {
        getModel().getScene().start();
    }

    public void actionPause() {
        getModel().getScene().pause();

    }

    public void actionReset() {
        actionPause();
        getModel().getScene().reset();
    }

    public void changeScene(String sceneName) {
        actionPause();
        actionReset();

        Rectangle bounds = getModel().getBounds();
        if (sceneName.equals(MenuModel.Collisions))
            getModel().setScene(new BigScene(bounds));

        if (sceneName.equals(MenuModel.Simple))
            getModel().setScene(new SmallScene(bounds));

        if (sceneName.equals(MenuModel.GameOfLife))
            getModel().setScene(new GameOfLifeScene(bounds));

        getModel().getScene().initialize();
    }

    public void changeSpeed(int speed) {
        getModel().getScene().setSpeed(speed);
    }
}
