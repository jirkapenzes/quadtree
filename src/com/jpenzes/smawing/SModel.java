package com.jpenzes.smawing;

import java.util.Observable;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 10:59
 */
public abstract class SModel extends Observable {

    private boolean isEnabledRequestNotify = true;

    public void requestNotify() {
        setChanged();

        if (isEnabledRequestNotify)
            notifyObservers(this);
    }

    public void setEnabledRequestNotify(boolean enabledRequestNotify) {
        isEnabledRequestNotify = enabledRequestNotify;
        notifyObservers(this);
    }
}