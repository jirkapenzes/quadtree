package com.jpenzes.smawing;

import com.jpenzes.smawing.utils.IFrameFactory;
import com.jpenzes.smawing.utils.IObjectContainer;
import com.jpenzes.smawing.utils.ObjectContainer;
import com.jpenzes.smawing.utils.SDefaultFrameFactory;

import javax.swing.*;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 10:55
 */
public abstract class SFrame {

    private JFrame frame;
    private final IObjectContainer<Class, SView<? extends SModel>> views;
    private final IObjectContainer<Class, SController<? extends SView<? extends SModel>, ? extends SModel>> controllers;
    private final IObjectContainer<Class, SModel> models;
    private final IFrameFactory frameFactory;

    protected SFrame() {
        this(new SDefaultFrameFactory());
    }

    protected SFrame(IFrameFactory frameFactory) {
        this.frameFactory = frameFactory;
        this.models = new ObjectContainer<Class, SModel>();
        this.views = new ObjectContainer<Class, SView<? extends SModel>>();
        this.controllers = new ObjectContainer<Class, SController<? extends SView<? extends SModel>, ? extends SModel>>();

        initialize();
        registerAllModels();
        registerAllViews();
        registerAllControllers();
    }

    protected abstract void initialize();

    protected abstract void registerAllModels();

    protected abstract void registerAllViews();

    protected abstract void registerAllControllers();

    protected abstract JFrame layout();

    public void show() {
        if (frame == null) {
            frame = layout();
            initializeControllers();
        }
        frameFactory.showFrame(frame);
    }

    private void initializeControllers() {
        for (SController controller : controllers) {
            controller.initialize();
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    protected IFrameFactory getFrameFactory() {
        return frameFactory;
    }

    public <View extends SView<? extends SModel>> View getView(Class<View> viewClass) {
        return views.get(viewClass);
    }

    public <Controller extends SController<? extends SView<? extends SModel>, ? extends SModel>> Controller getController(Class<Controller> controllerClass) {
        return controllers.get(controllerClass);
    }

    public <Model extends SModel> Model getModel(Class<Model> modelClass) {
        return models.get(modelClass);
    }

    protected <View extends SView<? extends SModel>> void registerView(Class className, View view) {
        views.register(className, view);
    }

    protected <Controller extends SController<? extends SView<? extends SModel>, ? extends SModel>> void registerController(Class className, Controller controller) {
        controllers.register(className, controller);
    }

    protected <Model extends SModel> void registerModel(Class className, Model model) {
        models.register(className, model);
    }
}
