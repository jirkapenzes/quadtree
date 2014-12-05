package com.jpenzes.ui;

import com.jpenzes.app.scenarious.Scene;
import com.jpenzes.tree.*;
import com.jpenzes.tree.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:58 PM
 */
public class QuadTreePanel extends JPanel implements Observer {

    private Scene<? extends Geometry2DObject> scene;
    private int pixelSize;
    private boolean isGrid;
    private boolean isCellBackgroundColor;
    private HashMap<Integer, Color> backgroundColors;

    public QuadTreePanel(int pixelSize, Scene<? extends Geometry2DObject> scene) {
        this.pixelSize = pixelSize;
        backgroundColors = new HashMap<>();
        backgroundColors.put(512, new Color(198, 233, 194));
        backgroundColors.put(256, new Color(198, 233, 194));
        backgroundColors.put(128, new Color(171, 208, 162));
        backgroundColors.put(64, new Color(130, 191, 126));
        backgroundColors.put(32, new Color(103, 167, 92));
        backgroundColors.put(16, new Color(72, 148, 55));
        backgroundColors.put(8, new Color(57, 120, 40));
        backgroundColors.put(4, new Color(63, 109, 41));

        setScene(scene);
        initializeUI();
    }

    private void initializeUI() {
        setBackground(new Color(255, 255, 255));
        setGrid(true);
        setCellBackgroundColor(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, getWidth(), getHeight());

        if (isCellBackgroundColor) {
            for (Rectangle rectangle : scene.getQuadTree().getAllUseRectangles()) {
                graphics.setColor(backgroundColors.get(rectangle.getWidth()));
                graphics.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
            }
        }

        if (isGrid) {
            graphics2D.setColor(new Color(220, 220, 220));
            for (int i = 0; i < getWidth(); i = i + pixelSize / 2) {
                graphics.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i < getHeight(); i = i + pixelSize / 2) {
                graphics.drawLine(0, i, getWidth(), i);
            }
            graphics2D.setColor(new Color(190, 190, 190));
            for (int i = 0; i < getWidth(); i = i + pixelSize) {
                graphics.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i < getHeight(); i = i + pixelSize) {
                graphics.drawLine(0, i, getWidth(), i);
            }
        }

        for (Rectangle rectangle : scene.getQuadTree().getAllUseRectangles()) {
            graphics.setColor(Color.black);
            graphics.drawRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }

        scene.drawScene(graphics2D);
    }

    public void setScene(Scene<? extends Geometry2DObject> scene) {
        this.scene = scene;
        this.scene.addObserver(this);
        repaint();
    }

    public void setGrid(boolean isGrid) {
        this.isGrid = isGrid;
        repaint();
    }

    public void setCellBackgroundColor(boolean isBackgroundColor) {
        this.isCellBackgroundColor = isBackgroundColor;
        repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
