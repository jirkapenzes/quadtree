package com.jpenzes.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Jirka Penzes
 * Date: 11/25/14 12:15 AM
 */
public class QuadTree<Element extends Geometry2DObject> {

    public enum Quadrant {TopLeft, TopRight, BottomLeft, BottomRight}

    private final int max_objects_capacity = 1;
    private final int max_level = 8;

    private final int level;
    private final Rectangle bounds;
    private final ArrayList<Element> objects;
    private final HashMap<Quadrant, QuadTree<Element>> nodes;

    public QuadTree(Rectangle bounds) {
        this(1, bounds);
    }

    private QuadTree(int level, Rectangle bounds) {
        this.level = level;
        this.bounds = bounds;
        this.objects = new ArrayList<>();
        this.nodes = new HashMap<>();

        for (Quadrant quadrant : Quadrant.values()) {
            this.nodes.put(quadrant, null);
        }
    }

    public void insert(Element element) {
        if (!bounds.containsPoint(element.getPoint())) {
            return;
        }

        Quadrant objectQuadrant = findQuadrant(element.getPoint());
        if (nodes.get(objectQuadrant) != null) {
            nodes.get(objectQuadrant).insert(element);
            return;
        }

        objects.add(element);
        if (objects.size() > max_objects_capacity && level <= max_level) {
            split();

            for (Element dataContainer : objects) {
                Quadrant quadrant = findQuadrant(dataContainer.getPoint());
                nodes.get(quadrant).insert(dataContainer);
            }
            objects.clear();
        }
    }

    private Quadrant findQuadrant(Point point) {
        Point midPoint = bounds.getMidPoint();
        if (point.getX() <= midPoint.getX() && point.getY() <= midPoint.getY()) return Quadrant.TopLeft;
        if (point.getX() >= midPoint.getX() && point.getY() <= midPoint.getY()) return Quadrant.TopRight;
        if (point.getX() <= midPoint.getX() && point.getY() >= midPoint.getY()) return Quadrant.BottomLeft;
        if (point.getX() >= midPoint.getX() && point.getY() >= midPoint.getY()) return Quadrant.BottomRight;
        return null;
    }

    private void split() {
        int subWidth = bounds.getWidth() / 2;
        int subHeight = bounds.getHeight() / 2;

        nodes.put(Quadrant.TopLeft, new QuadTree<>(level + 1, new Rectangle(bounds.getX(), bounds.getY(), subWidth, subHeight)));
        nodes.put(Quadrant.TopRight, new QuadTree<>(level + 1, new Rectangle(bounds.getX() + subWidth, bounds.getY(), subWidth, subHeight)));
        nodes.put(Quadrant.BottomLeft, new QuadTree<>(level + 1, new Rectangle(bounds.getX(), bounds.getY() + subHeight, subWidth, subHeight)));
        nodes.put(Quadrant.BottomRight, new QuadTree<>(level + 1, new Rectangle(bounds.getX() + subWidth, bounds.getY() + subHeight, subWidth, subHeight)));
    }

    public ArrayList<Rectangle> getAllUseRectangles() {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(bounds);

        for (Quadrant quadrant : Quadrant.values()) {
            if (nodes.get(quadrant) != null)
                rectangles.addAll(nodes.get(quadrant).getAllUseRectangles());
        }

        return rectangles;
    }

    public List<Element> getValues() {
        List<Element> values = objects.stream().collect(Collectors.toList());
        for (Quadrant quadrant : Quadrant.values()) {
            if (nodes.get(quadrant) != null)
                values.addAll(nodes.get(quadrant).getValues());
        }

        return values;
    }

    public HashSet<Element> find(Rectangle rectangle) {
        HashSet<Element> results = new HashSet<>();

        if (!bounds.intersects(rectangle)) {
            return results;
        }

        results.addAll(objects.stream()
                .filter(obj -> rectangle.containsPoint(obj.getPoint()))
                .collect(Collectors.toList()));

        if (hasNodes()) {
            for (Quadrant quadrant : Quadrant.values()) {
                results.addAll(nodes.get(quadrant).find(rectangle));
            }
        }
        return results;
    }

    private boolean hasNodes() {
        return nodes.get(Quadrant.BottomLeft) != null;
    }
}
