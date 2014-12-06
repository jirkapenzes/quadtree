package com.jpenzes.app.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

/**
 * Author: Jirka Penzes
 * Date: 12/6/14 11:47 AM
 */
public class BearInjector {

    private boolean activate = false;
    private String password = "bear";
    private int level = 0;
    private JComponent canvas;
    private static BearInjector resource = new BearInjector();

    private BearInjector() {
    }

    public BearInjector(JComponent canvas) {
        this.canvas = canvas;

        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                String currentChar = password.substring(level, level + 1);
                if (String.valueOf(keyEvent.getKeyChar()).equals(currentChar)) {
                    level++;
                } else {
                    level = 0;
                }

                if (level == password.length()) {
                    drawBear();
                }
            }
        });
    }

    private void drawBear() {
        if (activate) {
            Graphics2D graphics2D = (Graphics2D) canvas.getGraphics();
            Image pandaImage = getImage("bear.jpg");
            graphics2D.drawImage(pandaImage, 0, 0, 856, 536, canvas);
            graphics2D.dispose();
            level = 0;
        }
    }

    public void activate() {
        activate = true;
    }

    public static Image getImage(String resourceName) {
        URL url = resource.getClass().getResource("/com/jpenzes/app/util/resource/" + resourceName);
        try {
            return ImageIO.read(url);
        } catch (IOException exception) {
            return null;
        }
    }
}
