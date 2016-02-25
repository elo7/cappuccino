package com.elo7.cappuccino.actions;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;

import com.elo7.cappuccino.matchers.DelayedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

public class ActionSearchView extends DelayedMatcher {

    private String mText;

    public ActionSearchView withText(String text) {
        mText = text;
        return this;
    }

    @Override
    public void perform() {
        super.perform();

        if (!TextUtils.isEmpty(mText)) {
            onView(isAssignableFrom(EditText.class))
                    .perform(typeText(mText), pressKey(KeyEvent.KEYCODE_ENTER));
        }
    }
}
