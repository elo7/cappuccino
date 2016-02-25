package com.elo7.cappuccino.matchers;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ItemRecyclerViewMatcher extends TypeSafeMatcher<View> {
    private String itemText;

    public ItemRecyclerViewMatcher(String itemText, Class<? extends ViewGroup> expectedType) {
        super(expectedType);
        this.itemText = itemText;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(
                String.format(
                        "is isDescendantOf a %s with text %s",
                        RecyclerView.class.getCanonicalName(),
                        itemText
                )
        );
    }

    @Override
    protected boolean matchesSafely(View item) {
        return allOf(
                isDescendantOfA(isAssignableFrom(RecyclerView.class)),
                withText(itemText)).matches(item);
    }
}
