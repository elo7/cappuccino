package com.elo7.cappuccino.actions;

import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.view.ViewGroup;

import com.elo7.cappuccino.matchers.ColorMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsEqual.equalTo;

public class ActionHasBackgroundColor extends AbstractAction {

    private int mResId;
    private int mColorId;
    private int mParentId;

    public ActionHasBackgroundColor inView(@IdRes int resId) {
        mResId = resId;
        return this;
    }

    public ActionHasBackgroundColor inParent(@IdRes int parentId) {
        mParentId = parentId;
        return this;
    }

    public ActionHasBackgroundColor withColor(@ColorRes int colorId) {
        mColorId = colorId;
        return this;
    }

    @Override
    public void perform() {
        actionDelay();

        onView(allOf(withId(mResId), withParent(withId(mParentId))))
                .check(matches(new ColorMatcher(equalTo(mColorId), ViewGroup.class)));
    }
}
