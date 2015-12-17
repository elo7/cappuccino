package com.elo7.cappuccinno.actions;

public abstract class AbstractAction {
    protected long mDelayTime;

    public abstract void perform();

    public AbstractAction withDelay(long delayTime) {
        this.mDelayTime = delayTime;
        return this;
    }

    protected void actionDelay() {
        if (mDelayTime > 0) {
            try {
                wait(mDelayTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
