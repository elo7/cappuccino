package com.elo7.cappuccinotest;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityTestCase;

import com.elo7.cappuccinotest.utils.DumbActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.elo7.cappuccino.Cappuccino.actionHasText;

/**
 * Created by Developer on 12/22/15.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private Instrumentation.ActivityMonitor mMonitor;

    public Instrumentation getInstrumentation() {
        return InstrumentationRegistry.getInstrumentation();
    }

    @Before
    public void setUp() {
        registerMonitor(DumbActivity.class);
    }

    public void registerMonitor(Class<? extends Activity> activityClass) {
        removeMonitor();
        mMonitor = new Instrumentation.ActivityMonitor(activityClass.getName(), null, false);
        getInstrumentation().addMonitor(mMonitor);
    }

    public void removeMonitor() {
        if (mMonitor != null) {
            getInstrumentation().removeMonitor(mMonitor);
        }
    }

    @Test
    public void testSomeAction() {
        actionHasText(mActivityRule.getActivity().getString(R.string.hello_world)).perform();
    }

}
