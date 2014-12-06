package com.jpenzes.app.scenarious.gol;

import com.jpenzes.tree.Rectangle;

import java.util.HashSet;

/**
 * Author: Jirka Penzes
 * Date: 12/6/14 4:33 PM
 */
public class GunCellularAutomaton extends GameOfLifeScene {

    public GunCellularAutomaton(Rectangle bounds) {
        super(bounds);
    }

    @Override
    public void initialize() {
        liveCells = new HashSet<>();

        liveCells.add(new Cell(4, 8, gridSize));
        liveCells.add(new Cell(4, 9, gridSize));
        liveCells.add(new Cell(5, 8, gridSize));
        liveCells.add(new Cell(5, 9, gridSize));

        liveCells.add(new Cell(14, 8, gridSize));
        liveCells.add(new Cell(14, 9, gridSize));
        liveCells.add(new Cell(14, 10, gridSize));
        liveCells.add(new Cell(15, 7, gridSize));
        liveCells.add(new Cell(16, 6, gridSize));
        liveCells.add(new Cell(17, 6, gridSize));
        liveCells.add(new Cell(15, 11, gridSize));
        liveCells.add(new Cell(16, 12, gridSize));
        liveCells.add(new Cell(17, 12, gridSize));

        liveCells.add(new Cell(18, 9, gridSize));
        liveCells.add(new Cell(20, 9, gridSize));
        liveCells.add(new Cell(20, 8, gridSize));
        liveCells.add(new Cell(20, 10, gridSize));
        liveCells.add(new Cell(19, 11, gridSize));
        liveCells.add(new Cell(19, 7, gridSize));
        liveCells.add(new Cell(21, 9, gridSize));

        liveCells.add(new Cell(24, 8, gridSize));
        liveCells.add(new Cell(25, 8, gridSize));
        liveCells.add(new Cell(24, 7, gridSize));
        liveCells.add(new Cell(25, 7, gridSize));
        liveCells.add(new Cell(24, 6, gridSize));
        liveCells.add(new Cell(25, 6, gridSize));

        liveCells.add(new Cell(26, 5, gridSize));
        liveCells.add(new Cell(26, 9, gridSize));
        liveCells.add(new Cell(28, 5, gridSize));
        liveCells.add(new Cell(28, 9, gridSize));
        liveCells.add(new Cell(28, 4, gridSize));
        liveCells.add(new Cell(28, 10, gridSize));

        liveCells.add(new Cell(38, 6, gridSize));
        liveCells.add(new Cell(38, 7, gridSize));
        liveCells.add(new Cell(39, 6, gridSize));
        liveCells.add(new Cell(39, 7, gridSize));
    }
}
