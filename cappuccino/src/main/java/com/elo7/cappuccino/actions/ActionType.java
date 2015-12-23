package com.elo7.cappuccino.actions;

import android.support.annotation.IdRes;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionType extends DelayedMatcher {
    private int mViewId;
    private String mText;

    public ActionType inView(@IdRes int viewId) {
        this.mViewId = viewId;
        return this;
    }

    public ActionType withText(String text) {
        mText = text;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        new ActionClearText().inView(mViewId).perform();
        onView(withId(mViewId)).perform(typeText(mText));
        closeSoftKeyboard();
    }
}
