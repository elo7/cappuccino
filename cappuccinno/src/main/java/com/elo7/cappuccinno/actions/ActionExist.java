package com.elo7.cappuccinno.actions;
import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public final class ActionExist extends AbstractAction {
    private int mViewId;
    private String mText;

    public ActionExist withText(String text) {
        mText = text;
        return this;
    }

    public ActionExist inView(@IdRes int resId) {
        this.mViewId = resId;
        return this;
    }

    @Override
    public void perform() {
        actionDelay();

        if (mText != null && mViewId == 0) {
            onView(android.support.test.espresso.matcher.ViewMatchers.withText(mText)).check(matches(isDisplayed()));
        } else if (mText == null && mViewId != 0) {
            onView(withId(mViewId)).check(matches(isDisplayed()));
        } else {
            onView(allOf(android.support.test.espresso.matcher.ViewMatchers.withText(mText), withId(mViewId))).check(matches(isDisplayed()));
        }
    }
}
