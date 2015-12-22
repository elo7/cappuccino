package com.elo7.cappuccinno;

import android.support.annotation.IdRes;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.v4.view.ViewPager;

import com.elo7.cappuccinno.actions.ActionClearText;
import com.elo7.cappuccinno.actions.ActionClick;
import com.elo7.cappuccinno.actions.ActionExist;
import com.elo7.cappuccinno.actions.ActionHasBackgroundColor;
import com.elo7.cappuccinno.actions.ActionSwipeLeft;
import com.elo7.cappuccinno.actions.ActionSwipeRight;
import com.elo7.cappuccinno.actions.ActionType;
import com.elo7.cappuccinno.idling.ViewPagerIdlingResource;

import java.util.List;

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

    public static ActionSwipeLeft actionSwipeLeft() {
        return new ActionSwipeLeft();
    }

    public static ActionSwipeRight actionSwipeRight() {
        return new ActionSwipeRight();
    }

    public static ActionHasBackgroundColor actiobHasBackgroundColor() {
        return new ActionHasBackgroundColor();
    }

    public static void registerViewPagerIdlingResource(final ViewPager viewPager) {
        List<IdlingResource> idlingResources = Espresso.getIdlingResources();

        if (idlingResources != null && idlingResources.size() > 0) {
            for (IdlingResource idlingResource : idlingResources) {
                Espresso.unregisterIdlingResources(idlingResource);
            }
        }

        ViewPagerIdlingResource viewPagerIdlingResource = new ViewPagerIdlingResource(viewPager);
        Espresso.registerIdlingResources(viewPagerIdlingResource);
    }

    public static void waitLittle() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
