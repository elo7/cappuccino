package com.elo7.cappuccino.actions;

import android.view.ViewGroup;

import com.elo7.cappuccino.matchers.DelayedMatcher;
import com.elo7.cappuccino.matchers.ItemRecyclerViewMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class ActionRecyclerView extends DelayedMatcher {

    private String mText;

    public ActionRecyclerView withItemText(String itemText) {
        mText = itemText;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        onView(new ItemRecyclerViewMatcher(mText, ViewGroup.class)).check(matches(isDisplayed()));
    }

}
