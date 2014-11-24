package com.jpenzes.smawing.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 11:02
 */
public class SDefaultFrameFactory implements IFrameFactory {

    @Override
    public JFrame frame(String title, JComponent contentPane) {
        return frame(title, contentPane, null);
    }

    @Override
    public JFrame frame(String title, JComponent contentPane, JMenuBar menuBar) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        if (title != null) frame.setTitle(title);
        if (menuBar != null) frame.setJMenuBar(menuBar);
        if (contentPane != null) frame.getContentPane().add(contentPane, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1000, 600));
        return frame;
    }

    @Override
    public JFrame showFrame(JFrame frame) {
        frame.pack();
        centerFrame(frame);
        frame.setVisible(true);
        return frame;
    }

    private JFrame centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;
        if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        return frame;
    }
}
