package com.jpenzes.app.scenarious.gol;

import com.jpenzes.app.scenarious.Scene;
import com.jpenzes.tree.*;
import com.jpenzes.tree.Rectangle;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * Author: Jirka Penzes
 * Date: 12/4/14 6:22 PM
 */
public abstract class GameOfLifeScene extends Scene<Cell> {

    protected final int gridSize = 16;
    protected HashSet<Cell> liveCells;
    private int worldWidth;
    private int worldHeight;

    public GameOfLifeScene(Rectangle bounds) {
        super(bounds);

        worldWidth = getBounds().getWidth() / gridSize;
        worldHeight = getBounds().getHeight() / gridSize;
    }

    @Override
    public void process() {
        HashSet<Cell> newGeneration = new HashSet<>();
        HashSet<Cell> deadCells = new HashSet<>();

        for (Cell cell : liveCells)
            getQuadTree().insert(cell);

        for (Cell cell : liveCells) {
            int numberOfNeighbours = getNumberOfNeighbours(cell);
            if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
                newGeneration.add(cell);
            }

            deadCells.addAll(findDeadNeighboursCells(cell));
        }

        for (Cell cell : deadCells) {
            int numberOfNeighbours = getNumberOfNeighbours(cell);
            if (numberOfNeighbours == 3) {
                newGeneration.add(cell);
            }
        }

        liveCells = newGeneration;

        cleanQuadTree();
        for (Cell cell : liveCells)
            getQuadTree().insert(cell);
    }

    private Collection<? extends Cell> findDeadNeighboursCells(Cell cell) {
        HashSet<Cell> deadNeighbours = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int x = cell.getWorldPoint().getX() + i;
                int y = cell.getWorldPoint().getY() + j;

                if (x < 0) x = worldWidth - 1;
                if (x > (worldWidth - 1)) x = 0;
                if (y < 0) y = worldHeight - 1;
                if (y > (worldHeight - 1)) x = 0;

                Cell deadCells = new Cell(x, y, 16);
                if (!liveCells.contains(deadCells)) {
                    deadNeighbours.add(deadCells);
                }
            }
        }

        return deadNeighbours;
    }

    private int getNumberOfNeighbours(Cell cell) {
        int result = 0;
        Rectangle rectangle = new Rectangle(cell.getPoint().getX() - (gridSize), cell.getPoint().getY() - (gridSize), gridSize * 2 + 1, gridSize * 2 + 1);
        if (rectangle.getX() <= 0) {
            Cell tmpCell = new Cell(worldWidth - 1, cell.getWorldPoint().getY(), gridSize);
            Rectangle tmpRectangle = new Rectangle(tmpCell.getPoint().getX() - (gridSize / 4), tmpCell.getPoint().getY() - gridSize, gridSize / 2, gridSize * 2);
            result += getQuadTree().find(tmpRectangle).size();
        }

        if ((rectangle.getX() + rectangle.getWidth()) >= worldWidth) {
            Cell tmpCell = new Cell(0, cell.getWorldPoint().getY(), gridSize);
            Rectangle tmpRectangle = new Rectangle(tmpCell.getPoint().getX() - (gridSize / 4), tmpCell.getPoint().getY() - gridSize, gridSize / 2, gridSize * 2);
            result += getQuadTree().find(tmpRectangle).size();
        }

        if (rectangle.getX() <= 0) {
            Cell tmpCell = new Cell(cell.getWorldPoint().getX(), worldHeight - 1, gridSize);
            Rectangle tmpRectangle = new Rectangle(tmpCell.getPoint().getX() - gridSize, tmpCell.getPoint().getY() - (gridSize / 4), gridSize * 2, gridSize / 2);
            result += getQuadTree().find(tmpRectangle).size();
        }

        if ((rectangle.getY() + rectangle.getHeight()) >= worldHeight) {
            Cell tmpCell = new Cell(cell.getWorldPoint().getX(), 0, gridSize);
            Rectangle tmpRectangle = new Rectangle(tmpCell.getPoint().getX() - gridSize, tmpCell.getPoint().getY() - (gridSize / 4), gridSize * 2, gridSize / 2);
            result += getQuadTree().find(tmpRectangle).size();
        }

        result += getQuadTree().find(rectangle).size();
        if (liveCells.contains(cell))
            result = result - 1;

        return result;
    }


    @Override
    public void drawScene(Graphics2D graphics2D) {
        for (Cell cell : liveCells) {
            cell.draw(graphics2D);
        }
    }
}
