package com.elo7.cappuccinno.actions;
import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionClick extends AbstractAction {
    private int mResId;
    private String mText;

    public ActionClick inView(@IdRes int resId) {
        mResId = resId;
        return this;
    }

    public ActionClick withText(String text) {
        mText = text;
        return this;
    }

    @Override
    public void perform() {
        actionDelay();

        if (mText == null && mResId > 0) {
            onView(withId(mResId)).perform(click());
        } else {
            onView(android.support.test.espresso.matcher.ViewMatchers.withText(mText)).perform(click());
        }
    }

}
