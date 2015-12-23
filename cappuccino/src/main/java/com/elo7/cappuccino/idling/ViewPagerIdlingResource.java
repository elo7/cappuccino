package com.elo7.cappuccino.idling;

import android.support.test.espresso.IdlingResource;
import android.support.v4.view.ViewPager;

public class ViewPagerIdlingResource implements IdlingResource {

    private final ViewPager mViewPager;
    private static ResourceCallback mCallback;

    public ViewPagerIdlingResource(ViewPager viewPager) {
        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mCallback.onTransitionToIdle();
                }
            }
        });
    }

    @Override
    public String getName() {
        return ViewPagerIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        if (mViewPager != null && mViewPager.getAdapter() != null && mViewPager.getAdapter().getCount() > 0) {
            if (mCallback != null) {
                mCallback.onTransitionToIdle();
            }
            return true;
        }
        return false;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        mCallback = resourceCallback;
    }
}
