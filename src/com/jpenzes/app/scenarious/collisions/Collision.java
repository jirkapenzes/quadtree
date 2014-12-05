package com.jpenzes.app.scenarious.collisions;

import com.jpenzes.tree.Point;

import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 12/2/14 10:53 PM
 */
public class Collision {

    private Point point1;
    private Point point2;
    private boolean completed;

    private int currentStep;

    public Collision(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        completed = false;
    }

    public void explosion() {
        int totalSteps = 20;
        if (currentStep++ > totalSteps) {
            completed = true;
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(192, 31, 40, 100));
        int x = ((Math.max(point1.getX(), point2.getX()) - Math.min(point1.getX(), point2.getX())) / 2) + Math.min(point1.getX(), point2.getX());
        int y = ((Math.max(point1.getY(), point2.getY()) - Math.min(point1.getY(), point2.getY())) / 2) + Math.min(point1.getY(), point2.getY());

        int explosionSize = currentStep * 2;
        graphics2D.fillOval(x - (explosionSize / 2), y - (explosionSize / 2), explosionSize, explosionSize);

        graphics2D.setColor(new Color(192, 31, 40));
        graphics2D.drawOval(x - (explosionSize / 2), y - (explosionSize / 2), explosionSize, explosionSize);
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collision collision = (Collision) o;
        return point1.equals(collision.point2) || point2.equals(collision.point1);

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
