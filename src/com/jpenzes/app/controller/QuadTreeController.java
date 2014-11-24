package com.jpenzes.app.controller;

import com.jpenzes.app.model.QuadTreeModel;
import com.jpenzes.app.view.QuadTreeView;
import com.jpenzes.smawing.SController;
import com.jpenzes.smawing.SFrame;

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

    }
}
