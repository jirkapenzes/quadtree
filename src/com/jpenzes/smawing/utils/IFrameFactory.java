package com.jpenzes.smawing.utils;

import javax.swing.*;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 11:02
 */
public interface IFrameFactory {

    JFrame frame(String title, JComponent contentPane);

    JFrame frame(String title, JComponent contentPane, JMenuBar menuBar);

    JFrame showFrame(JFrame frame);

}
