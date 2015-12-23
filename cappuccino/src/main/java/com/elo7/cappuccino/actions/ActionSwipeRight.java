package com.elo7.cappuccino.actions;
import android.support.annotation.IdRes;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionSwipeRight extends DelayedMatcher {
    private int mViewId;

    public ActionSwipeRight inView(@IdRes int resId) {
        this.mViewId = resId;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        onView(withId(mViewId)).perform(swipeRight());
    }
}
