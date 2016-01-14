package com.elo7.cappuccino.actions;

import android.support.annotation.IdRes;
import android.support.test.espresso.contrib.RecyclerViewActions;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ActionScrollRecyclerView extends DelayedMatcher {
    private int mResId;
    private int mPosition;

    public ActionScrollRecyclerView inView(@IdRes int resId) {
        mResId = resId;
        return this;
    }

    public ActionScrollRecyclerView atPosition(int position) {
        mPosition = position;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        onView(withId(mResId)).perform(RecyclerViewActions.actionOnItemAtPosition(mPosition, scrollTo()));
    }
}
