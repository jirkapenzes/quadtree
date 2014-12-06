package com.jpenzes.app.scenarious.collisions;

import com.jpenzes.app.scenarious.Scene;
import com.jpenzes.tree.*;
import com.jpenzes.tree.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author: Jirka Penzes
 * Date: 12/1/14 4:22 PM
 */
public abstract class CollisionScene extends Scene<Ball> {

    private ArrayList<Ball> balls;
    private HashSet<Collision> collisions;

    public CollisionScene(Rectangle bounds) {
        super(bounds);

        this.balls = new ArrayList<>();
        this.collisions = new HashSet<>();
    }

    @Override
    public void initialize() {
        collisions.clear();
    }

    @Override
    public synchronized void process() {
        for (Ball ball : balls) {
            ball.move(getBounds());
            getQuadTree().insert(ball);
        }

        HashSet<Ball> collisionBalls;
        for (Ball ball : balls) {
            Rectangle rectangle = new Rectangle(ball.getPoint().getX() - 5, ball.getPoint().getY() - 5, 10, 10);

            collisionBalls = getQuadTree().find(rectangle);
            collisionBalls.remove(ball);
            for (Ball collisionBall : collisionBalls) {
                Collision collision = new Collision(ball.getPoint(), collisionBall.getPoint());

                if (!collisions.contains(collision)) {
                    collisions.add(collision);
                }
            }
        }

        for (Collision collision : collisions) {
            collision.explosion();
        }

        collisions.removeIf(Collision::isCompleted);
    }

    @Override
    public synchronized void drawScene(Graphics2D graphics2D) {
        for (Ball ball : balls) {
            ball.draw(graphics2D);
        }

        for (Collision collision : collisions) {
            collision.draw(graphics2D);
        }
    }

    protected ArrayList<Ball> getBalls() {
        return balls;
    }
}
