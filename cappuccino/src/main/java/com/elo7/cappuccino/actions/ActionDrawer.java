package com.elo7.cappuccino.actions;

import android.support.annotation.IdRes;
import android.support.test.espresso.contrib.DrawerActions;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionDrawer extends DelayedMatcher {

    private int mResId;

    public ActionDrawer inDrawerId(@IdRes int id) {
        mResId = id;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        if (mResId > 0) {
            onView(withId(mResId)).perform(DrawerActions.open());
        }
    }
}
