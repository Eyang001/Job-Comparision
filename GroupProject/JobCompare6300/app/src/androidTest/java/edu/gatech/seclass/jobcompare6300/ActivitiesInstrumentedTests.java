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

        onView(withId(R.id.companyField)).perform(typeText("SpaceX"), closeSoftKeyboard());
        onView(withId(R.id.companyField)).check(matches(withText("SpaceX")));

        onView(withId(R.id.cityField)).perform(typeText("Boca Chica"), closeSoftKeyboard());
        onView(withId(R.id.cityField)).check(matches(withText("Boca Chica")));

        onView(withId(R.id.stateField)).perform(typeText("Texas"), closeSoftKeyboard());
        onView(withId(R.id.stateField)).check(matches(withText("Texas")));

        onView(withId(R.id.colField)).perform(typeText("70"), closeSoftKeyboard());
        onView(withId(R.id.colField)).check(matches(withText("70")));

        onView(withId(R.id.salaryField)).perform(typeText("100000"), closeSoftKeyboard());
        onView(withId(R.id.salaryField)).check(matches(withText("100000")));

        onView(withId(R.id.bonusField)).perform(typeText("15000"), closeSoftKeyboard());
        onView(withId(R.id.bonusField)).check(matches(withText("15000")));

        onView(withId(R.id.teleworkField)).perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.teleworkField)).check(matches(withText("3")));

        onView(withId(R.id.leaveField)).perform(typeText("20"), closeSoftKeyboard());
        onView(withId(R.id.leaveField)).check(matches(withText("20")));

        onView(withId(R.id.gymField)).perform(typeText("200"), closeSoftKeyboard());
        onView(withId(R.id.gymField)).check(matches(withText("200")));
    }

    @Test
    public void enterJobOffer() {
        onView(withId(R.id.enterJobOfferButton)).perform(click());
        onView(withId(R.id.titleField)).perform(typeText("Test plumber"), closeSoftKeyboard());
        onView(withId(R.id.titleField)).check(matches(withText("Test plumber")));

        onView(withId(R.id.companyField)).perform(typeText("Home depot"), closeSoftKeyboard());
        onView(withId(R.id.companyField)).check(matches(withText("Home depot")));

        onView(withId(R.id.cityField)).perform(typeText("Los Angeles"), closeSoftKeyboard());
        onView(withId(R.id.cityField)).check(matches(withText("Los Angeles")));

        onView(withId(R.id.stateField)).perform(typeText("California"), closeSoftKeyboard());
        onView(withId(R.id.stateField)).check(matches(withText("California")));

        onView(withId(R.id.colField)).perform(typeText("120"), closeSoftKeyboard());
        onView(withId(R.id.colField)).check(matches(withText("120")));

        onView(withId(R.id.salaryField)).perform(typeText("70000"), closeSoftKeyboard());
        onView(withId(R.id.salaryField)).check(matches(withText("70000")));

        onView(withId(R.id.bonusField)).perform(typeText("10000"), closeSoftKeyboard());
        onView(withId(R.id.bonusField)).check(matches(withText("10000")));

        onView(withId(R.id.teleworkField)).perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.teleworkField)).check(matches(withText("0")));

        onView(withId(R.id.leaveField)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.leaveField)).check(matches(withText("30")));

        onView(withId(R.id.gymField)).perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.gymField)).check(matches(withText("0")));
    }

}
