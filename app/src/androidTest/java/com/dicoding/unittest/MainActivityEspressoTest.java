package com.dicoding.unittest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 4/8/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ensureTextChangeWork(){
        onView(withId(R.id.edt_panjang))
                .perform(typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.edt_lebar))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.btn_hitung)).perform(click());
    }

}
