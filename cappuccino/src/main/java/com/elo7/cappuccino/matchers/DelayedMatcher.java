package com.elo7.cappuccino.matchers;

public class DelayedMatcher {
    protected long mDelayTime;

    public DelayedMatcher withDelay(long delayTime) {
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

    protected void perform() {
        actionDelay();
    }
}
