package com.elo7.cappuccino.matchers;

import com.elo7.cappuccino.interfaces.OnActionListener;

public class DelayedMatcher implements OnActionListener {
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

    @Override
    public void perform() {
        actionDelay();
    }
}
