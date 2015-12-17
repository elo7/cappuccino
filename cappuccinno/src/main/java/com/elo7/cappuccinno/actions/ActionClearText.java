package com.elo7.cappuccinno.actions;
import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionClearText extends AbstractAction {
    private int mViewId;

    public ActionClearText inView(@IdRes int resId) {
        this.mViewId = resId;
        return this;
    }

    @Override
    public void perform() {
        actionDelay();

        onView(withId(mViewId)).perform(clearText());
    }
}
