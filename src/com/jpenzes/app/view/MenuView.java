package com.jpenzes.app.view;

import com.jpenzes.app.model.MenuModel;
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
            menuPanel = new MenuPanel(getModel().getStartButtonText());
        return menuPanel;
    }

    @Override
    protected void updateView() {
    }
}
