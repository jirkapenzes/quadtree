package com.jpenzes.app.scenarious.balls;

import com.jpenzes.tree.Rectangle;

import java.util.Random;

/**
 * Author: Jirka Penzes
 * Date: 12/10/14 12:36 PM
 */
public class RandomBallsScene extends BallsScene {

    public RandomBallsScene(Rectangle bounds) {
        super(bounds);
    }

    @Override
    public void initialize() {
        getBalls().clear();

        Random random = new Random(0);
        int numberOfBalls = 150;
        for (int index = 0; index < numberOfBalls; index++) {
            Ball ball = new Ball(random.nextInt(getBounds().getWidth()), random.nextInt(getBounds().getHeight()),
                    (random.nextBoolean() ? 1 : -1), (random.nextBoolean() ? 1 : -1));

            getBalls().add(ball);
        }
    }
}
