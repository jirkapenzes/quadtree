package com.jpenzes.app.scenarious.balls;

import com.jpenzes.app.scenarious.Scene;
import com.jpenzes.tree.Rectangle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Author: Jirka Penzes
 * Date: 12/10/14 12:28 PM
 */
public abstract class BallsScene extends Scene<Ball> {

    private ArrayList<Ball> balls;

    public BallsScene(Rectangle bounds) {
        super(bounds);

        this.balls = new ArrayList<>();
    }

    @Override
    public synchronized void process() {
        for (Ball ball : balls) {
            ball.move(getBounds());
            getQuadTree().insert(ball);
        }
    }

    @Override
    public synchronized void drawScene(Graphics2D graphics2D) {
        for (Ball ball : balls) {
            ball.draw(graphics2D);
        }
    }

    protected ArrayList<Ball> getBalls() {
        return balls;
    }

}
