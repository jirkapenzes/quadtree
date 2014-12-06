package com.jpenzes.app.util;

/**
 * Author: Jirka Penzes
 * Date: 12/1/14 4:53 PM
 */
public class ThreadHelper {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
