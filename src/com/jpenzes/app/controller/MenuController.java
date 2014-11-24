package com.jpenzes.app.controller;

import com.jpenzes.app.model.MenuModel;
import com.jpenzes.app.view.MenuView;
import com.jpenzes.smawing.SController;
import com.jpenzes.smawing.SFrame;

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

    }
}
