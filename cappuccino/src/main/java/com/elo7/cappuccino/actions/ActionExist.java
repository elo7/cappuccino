package com.elo7.cappuccino.actions;
import android.support.annotation.IdRes;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public final class ActionExist extends DelayedMatcher {
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
        super.perform();

        if (mText != null && mViewId == 0) {
            onView(android.support.test.espresso.matcher.ViewMatchers.withText(mText)).check(matches(isDisplayed()));
        } else if (mText == null && mViewId != 0) {
            onView(withId(mViewId)).check(matches(isDisplayed()));
        } else {
            onView(allOf(android.support.test.espresso.matcher.ViewMatchers.withText(mText), withId(mViewId))).check(matches(isDisplayed()));
        }
    }
}
