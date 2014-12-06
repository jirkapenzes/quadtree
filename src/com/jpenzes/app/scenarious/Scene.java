package com.jpenzes.app.scenarious;

import com.jpenzes.app.util.ThreadHelper;
import com.jpenzes.tree.*;
import com.jpenzes.tree.Rectangle;

import java.awt.*;
import java.util.Observable;

/**
 * Author: Jirka Penzes
 * Date: 12/1/14 4:45 PM
 */
public abstract class Scene<Data extends Geometry2DObject> extends Observable {

    private Rectangle bounds;
    private QuadTree<Data> quadTree;
    private volatile boolean running;
    private volatile int millis;

    protected Scene(Rectangle bounds) {
        this.bounds = bounds;
        this.quadTree = new QuadTree<>(getBounds());
        this.running = false;
    }

    public abstract void initialize();

    public void start() {
        running = true;

        new Thread(() -> {
            while (running) {
                cleanQuadTree();
                process();
                setChanged();
                notifyObservers();
                ThreadHelper.sleep(millis);
            }
        }).start();
    }

    public void reset() {
        cleanQuadTree();
        initialize();
        setChanged();
        notifyObservers();
    }

    public void pause() {
        running = false;
    }

    public abstract void process();

    public abstract void drawScene(Graphics2D graphics2D);

    public Rectangle getBounds() {
        return bounds;
    }

    public QuadTree<Data> getQuadTree() {
        return quadTree;
    }

    protected void cleanQuadTree() {
        quadTree = new QuadTree<>(getBounds());
    }

    public void setSpeed(int millis) {
        this.millis = millis;
    }
}
