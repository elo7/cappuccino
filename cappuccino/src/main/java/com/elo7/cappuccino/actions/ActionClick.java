package com.elo7.cappuccino.actions;
import android.support.annotation.IdRes;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionClick extends DelayedMatcher {
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
        super.perform();

        if (mText == null && mResId > 0) {
            onView(withId(mResId)).perform(click());
        } else {
            onView(android.support.test.espresso.matcher.ViewMatchers.withText(mText)).perform(click());
        }
    }

}
