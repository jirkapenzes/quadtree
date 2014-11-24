package com.jpenzes.smawing;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 10:59
 */
public abstract class SView<TModel extends SModel> implements Observer {

    private final SFrame frame;
    private final TModel model;
    private JComponent contentPane;

    protected SView(SFrame frame, Class<TModel> modelClassName) {
        this.frame = frame;
        this.model = getMainFrame().getModel(modelClassName);
        model.addObserver(this);
    }

    protected abstract JComponent layout();

    protected SFrame getMainFrame() {
        return frame;
    }

    protected TModel getModel() {
        return model;
    }

    public JComponent getContentPane() {
        if (contentPane == null) contentPane = layout();
        return contentPane;
    }

    @Override
    public void update(Observable observable, Object arg) {
        updateView();
    }

    protected abstract void updateView();
}
