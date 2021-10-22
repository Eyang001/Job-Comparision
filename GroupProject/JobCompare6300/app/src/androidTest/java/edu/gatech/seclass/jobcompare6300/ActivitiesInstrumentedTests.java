package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivitiesInstrumentedTests {

    @Rule
    public ActivityScenarioRule<MainActivity> mainRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void enterCurrentJob() {
        onView(withId(R.id.enterCurrentJobButton)).perform(click());
        onView(withId(R.id.titleField)).perform(typeText("Test engineer"), closeSoftKeyboard());
        onView(withId(R.id.titleField)).check(matches(withText("Test engineer")));
    }
}
