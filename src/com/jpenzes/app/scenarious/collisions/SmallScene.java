package com.jpenzes.app.scenarious.collisions;

import com.jpenzes.app.scenarious.balls.Ball;
import com.jpenzes.tree.Rectangle;


/**
 * Author: Jirka Penzes
 * Date: 12/3/14 11:52 PM
 */
public class SmallScene extends CollisionScene {

    public SmallScene(Rectangle bounds) {
        super(bounds);
    }

    @Override
    public void initialize() {
        super.initialize();

        Ball ball1 = new Ball(20, 20, 1, 1);
        Ball ball2 = new Ball(400, 400, -1, -1);
        Ball ball3 = new Ball(800, 20, 1, 1);
        Ball ball4 = new Ball(20, 400, 1, 1);

        getBalls().clear();
        getBalls().add(ball1);
        getBalls().add(ball2);
        getBalls().add(ball3);
        getBalls().add(ball4);
    }
}
