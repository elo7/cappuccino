package com.elo7.cappuccinno;

import android.support.annotation.IdRes;

import com.elo7.cappuccinno.actions.ActionClearText;
import com.elo7.cappuccinno.actions.ActionClick;
import com.elo7.cappuccinno.actions.ActionExist;
import com.elo7.cappuccinno.actions.ActionType;

public class Cappuccino {

    //Should we create an ActionHasText class?
    public static ActionExist actionHasText(String text) {
        return new ActionExist().withText(text);
    }

    public static ActionClick actionClick() {
        return new ActionClick();
    }

    public static ActionType actionType() {
        return new ActionType();
    }

    public static ActionExist actionExist(@IdRes int resId) {
        return new ActionExist().inView(resId);
    }

    public static ActionClearText actionClearField() {
        return new ActionClearText();
    }
}
