package com.jpenzes.app.scenarious.collisions;

import com.jpenzes.tree.Geometry2DObject;
import com.jpenzes.tree.Rectangle;

import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 12/1/14 11:02 PM
 */
public class Ball implements Geometry2DObject {

    private int x;
    private int y;
    private double dx;
    private double dy;
    private final int size = 10;

    public Ball(int x, int y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move(Rectangle bounds) {
        x += dx;
        y += dy;

        if (x < bounds.getX()) {
            x = bounds.getX();
            dx = -dx;
        }
        if (x + size >= bounds.getWidth()) {
            x = bounds.getWidth() - size;
            dx = -dx;
        }
        if (y < bounds.getY()) {
            y = bounds.getY();
            dy = -dy;
        }
        if (y + size >= bounds.getHeight()) {
            y = bounds.getHeight() - size;
            dy = -dy;
        }
    }

    public com.jpenzes.tree.Point getPoint() {
        return new com.jpenzes.tree.Point(x, y);
    }

    public void draw(Graphics2D graphics2D) {
        Stroke previousStroke = graphics2D.getStroke();
        graphics2D.setColor(new Color(129, 198, 235));
        graphics2D.fillOval(x - (size / 2), y - (size / 2), size, size);
        BasicStroke lineStroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graphics2D.setStroke(lineStroke);
        graphics2D.setColor(new Color(48, 111, 186));
        graphics2D.drawOval(x - (size / 2), y - (size / 2), size, size);
        graphics2D.setStroke(previousStroke);
    }
}
