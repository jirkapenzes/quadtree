package com.jpenzes.app.view;

import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.smawing.SFrame;
import com.jpenzes.smawing.SView;
import com.jpenzes.ui.QuadTreePanel;

import javax.swing.*;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:43 PM
 */
public class QuadTreeView extends SView<QuadTreeModel> {

    private QuadTreePanel quadTreePanel;

    public QuadTreeView(SFrame frame, Class<QuadTreeModel> modelClassName) {
        super(frame, modelClassName);
    }

    @Override
    protected JComponent layout() {
        if (quadTreePanel == null) {
            quadTreePanel = new QuadTreePanel(16, getModel().getScene());
        }
        return quadTreePanel;
    }

    @Override
    public void updateView() {
        boolean isGrid = getMainFrame().getModel(MenuModel.class).isGrid();
        boolean isCellBackgroundColor = getMainFrame().getModel(MenuModel.class).isCellBackgroundColor();

        quadTreePanel.setGrid(isGrid);
        quadTreePanel.setCellBackgroundColor(isCellBackgroundColor);
        quadTreePanel.setScene(getModel().getScene());
    }
}
