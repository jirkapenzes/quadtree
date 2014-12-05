package com.jpenzes.tree;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Author: Jirka Penzes
 * Date: 11/25/14 12:45 PM
 */
public class Rectangle {

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Point getMidPoint() {
        return new Point(getX() + (getWidth() / 2), getY() + (getHeight() / 2));
    }

    public boolean intersects(Rectangle rectangle) {
        return rectangle.width > 0 && rectangle.height > 0 && width > 0 && height > 0
                && rectangle.x <= x + width && rectangle.x + rectangle.width >= x
                && rectangle.y <= y + height && rectangle.y + rectangle.height >= y;
    }

    public boolean containsPoint(Point point) {
        return point.getX() >= getX() && point.getX() <= (getX() + getWidth())
                && point.getY() >= getY() && point.getY() <= getY() + getHeight();
    }
}
