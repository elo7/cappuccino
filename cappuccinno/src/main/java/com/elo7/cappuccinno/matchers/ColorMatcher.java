package com.elo7.cappuccinno.matchers;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ColorMatcher extends BoundedMatcher<Object, ViewGroup> {
    private Matcher<Integer> mExpectedObject;
    private int mColor;

    public ColorMatcher(final Matcher<Integer> expectedObject, Class<? extends ViewGroup> expectedType) {
        super(expectedType);
        mExpectedObject = expectedObject;
    }

    @Override
    protected boolean matchesSafely(ViewGroup item) {
        mColor = ((ColorDrawable) item.getBackground()).getColor();
        return mExpectedObject.matches(mColor);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Color did not match " + mColor);
    }
}
