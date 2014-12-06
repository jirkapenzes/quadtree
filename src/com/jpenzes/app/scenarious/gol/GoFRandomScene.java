package com.jpenzes.app.scenarious.gol;

import com.jpenzes.tree.Rectangle;

import java.util.HashSet;
import java.util.Random;

/**
 * Author: Jirka Penzes
 * Date: 12/6/14 4:29 PM
 */
public class GoFRandomScene extends GameOfLifeScene {

    private int numberOfCells;

    public GoFRandomScene(Rectangle bounds, int numberOfCells) {
        super(bounds);
        this.numberOfCells = numberOfCells;
    }

    @Override
    public void initialize() {
        liveCells = new HashSet<>();

        Random r = new Random(0);
        for (int i = 0; i < numberOfCells; i++) {
            int x = r.nextInt(getBounds().getWidth() / gridSize);
            int y = r.nextInt(getBounds().getHeight() / gridSize);

            liveCells.add(new Cell(x, y, gridSize));
        }
    }
}
