package com.jpenzes.app;

import com.jpenzes.app.controller.MenuController;
import com.jpenzes.app.controller.QuadTreeController;
import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.app.view.MenuView;
import com.jpenzes.app.view.QuadTreeView;
import com.jpenzes.smawing.SFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:30 PM
 */
public class QuadTreeFrame extends SFrame {

    @Override
    protected void initialize() {
    }

    @Override
    protected void registerAllModels() {
        registerModel(MenuModel.class, new MenuModel());
        registerModel(QuadTreeModel.class, new QuadTreeModel());
    }

    @Override
    protected void registerAllViews() {
        registerView(MenuView.class, new MenuView(this, MenuModel.class));
        registerView(QuadTreeView.class, new QuadTreeView(this, QuadTreeModel.class));
    }

    @Override
    protected void registerAllControllers() {
        registerController(MenuController.class, new MenuController(this, MenuView.class, MenuModel.class));
        registerController(QuadTreeController.class, new QuadTreeController(this, QuadTreeView.class, QuadTreeModel.class));
    }

    @Override
    protected JFrame layout() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(getView(MenuView.class).getContentPane(), BorderLayout.SOUTH);
        contentPane.add(getView(QuadTreeView.class).getContentPane(), BorderLayout.CENTER);
        return getFrameFactory().frame("Quad tree demo", contentPane);
    }
}
