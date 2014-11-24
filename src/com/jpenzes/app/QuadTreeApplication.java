package com.jpenzes.app;

import javax.swing.*;

/**
 * Author: Jirka Penzes
 * Date: 11/24/14 10:53 PM
 */
public class QuadTreeApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuadTreeFrame mainFrame = new QuadTreeFrame();
                mainFrame.show();
            }
        });
    }
}
