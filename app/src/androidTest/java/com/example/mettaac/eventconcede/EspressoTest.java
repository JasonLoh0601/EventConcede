package com.example.mettaac.eventconcede;

import android.content.ComponentName;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by JasonLoh95 on 16/1/2018.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoTest {


    @Rule
    public ActivityTestRule<Login> mActivityRule = new IntentsTestRule<>(Login.class, true, false);

    @Rule
    public ActivityTestRule<MainPage> main = new ActivityTestRule<MainPage>(MainPage.class);

    private void launchActivityWithIntent()
    {
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
    }



    @Test
    public void loginSuccess()throws Exception
    {
        launchActivityWithIntent();

        onView(withId(R.id.email)).perform(typeText("jason@gmail.com"));

        onView(withId(R.id.password)).perform(typeText("123456"));

        onView(withId(R.id.login)).perform(click());

        // successful login moves user to next screen
        intended(hasComponent(new ComponentName(getTargetContext(), MainPage.class)));

        onData(hasToString(startsWith("")))
                .inAdapterView(withId(R.id.attraction)).atPosition(0)
                .perform(click());

        onView(withId(R.id.button2)).perform(click());


    }

    @Test
    public void loginSuccess2()throws Exception
    {
        launchActivityWithIntent();

        onView(withId(R.id.email)).perform(typeText("jason@gmail.com"));

        onView(withId(R.id.password)).perform(typeText("123456"));

        onView(withId(R.id.login)).perform(click());

        // successful login moves user to next screen
        intended(hasComponent(new ComponentName(getTargetContext(), MainPage.class)));

        onData(hasToString(startsWith("")))
                .inAdapterView(withId(R.id.attraction)).atPosition(0)
                .perform(click());

        onView(withId(R.id.button3)).perform(click());


    }

    @Test
    public void registerTest()
    {
        launchActivityWithIntent();

        onView(withId(R.id.registerconnector)).perform(click());

        onView(withId(R.id.name)).perform(typeText("jason"));

        onView(withId(R.id.Username)).perform(typeText("Jason Loh"));

        onView(withId(R.id.Password)).perform(typeText("123456"));

        onView(withId(R.id.email)).perform(typeText("jason123@gmail.com"));

        onView(withId(R.id.register)).perform(click());
    }

    @Test
    public void registerFailedTest()
    {
        launchActivityWithIntent();

        onView(withId(R.id.registerconnector)).perform(click());

        onView(withId(R.id.name)).perform(typeText("jason"));

        onView(withId(R.id.Username)).perform(typeText("Jason Loh"));

        onView(withId(R.id.Password)).perform(typeText("123456"));

        onView(withId(R.id.email)).perform(typeText("jason@gmail.com"));

        onView(withId(R.id.register)).perform(click());
    }

    @Test
    public void loginFailed()
    {
        launchActivityWithIntent();

        onView(withId(R.id.email)).perform(typeText("chris.ripple@grapecity.com"));

        onView(withId(R.id.password)).perform(typeText("NotPass"));

        onView(withId(R.id.login)).perform(click());


    }
}
