package com.elo7.cappuccino.actions;

import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionType extends AbstractAction {
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
        actionDelay();

        new ActionClearText().inView(mViewId).perform();
        onView(withId(mViewId)).perform(typeText(mText));
        closeSoftKeyboard();
    }
}
