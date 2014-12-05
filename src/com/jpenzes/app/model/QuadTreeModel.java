package com.jpenzes.app.model;

import com.jpenzes.app.scenarious.collisions.BigScene;
import com.jpenzes.app.scenarious.Scene;
import com.jpenzes.app.scenarious.gol.GameOfLifeScene;
import com.jpenzes.smawing.SModel;
import com.jpenzes.tree.Geometry2DObject;
import com.jpenzes.tree.Rectangle;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:44 PM
 */
public class QuadTreeModel extends SModel {

    public static int SpeedFast = 10;
    public static int SpeedSlow = 300;

    private Scene<? extends Geometry2DObject> scene;
    private Rectangle bounds;
    private int speed;

    public QuadTreeModel() {
        bounds = new Rectangle(1024, 512);

        setSpeed(SpeedFast);
        setScene(new BigScene(bounds));
    }

    public Scene<? extends Geometry2DObject> getScene() {
        return scene;
    }

    public void setScene(Scene<? extends Geometry2DObject> scene) {
        this.scene = scene;
        this.scene.setSpeed(speed);
        requestNotify();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        requestNotify();
    }
}
