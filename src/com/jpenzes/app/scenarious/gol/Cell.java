package com.jpenzes.app.scenarious.gol;

import com.jpenzes.tree.*;
import com.jpenzes.tree.Point;

import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 12/4/14 6:22 PM
 */
public class Cell implements Geometry2DObject {

    private Point point;
    private Point worldPoint;
    private int size;

    public Cell(int x, int y, int size) {
        this.point = new Point((x * size) + (size / 2), (y * size) + (size / 2));
        this.worldPoint = new Point(x, y);
        this.size = size;
    }

    public Point getWorldPoint() {
        return worldPoint;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(129, 198, 235));
        graphics2D.fillRect(getPoint().getX() - (size / 2), getPoint().getY() - (size / 2), size, size);

        graphics2D.setColor(new Color(48, 111, 186));
        graphics2D.drawRect(getPoint().getX() - (size / 2), getPoint().getY() - (size / 2), size, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;
        return !(worldPoint != null ? !worldPoint.equals(cell.worldPoint) : cell.worldPoint != null);

    }

    @Override
    public int hashCode() {
        return worldPoint != null ? worldPoint.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "point=" + point +
                '}';
    }
}
