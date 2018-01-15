package com.milnow5555.connect4.Activities;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.milnow5555.connect4.GameBoard.GameBoard;
import com.milnow5555.connect4.R;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class GameActivityTest {


    @Rule
    public ActivityTestRule<GameActivity> mActivityRule =
            new ActivityTestRule<>(GameActivity.class);

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

//    @Test
//    public void ensureThatButtonsCantBePlacedOnTheSamePlace() throws Exception {
//        onView(withId(R.id.img55)).perform(click());
//        onView(withId(R.id.img55)).perform(click());
//
//        onView(withText(R.string.occupy_toast)).
//                inRoot(withDecorView(not(is(mActivityRule.getActivity().
//                        getWindow().
//                        getDecorView())))).
//                check(matches(isDisplayed()));
//    }
    @Test
    public void ensureThatButtonsCantBePlacedOnTheRandomPlace() throws Exception {
        onView(withId(R.id.img00)).perform(click());

        onView(withText(R.string.fill_toast)).
                inRoot(withDecorView(not(is(mActivityRule.getActivity().
                        getWindow().
                        getDecorView())))).
                check(matches(isDisplayed()));

    }
    @Test
    public void ensureThatNumberOfTurnsIsRight() throws Exception {
        onView(withId(R.id.img55)).perform(click());
        onView(withId(R.id.turnNumber)).check(matches(withText("1")));
    }
    @Test
    public void checkIfEverythingIsRestartedAfterClickingRestartButton() throws Exception {

        onView(withId(R.id.img55)).perform(click());
        onView(withId(R.id.img54)).perform(click());
        onView(withId(R.id.img53)).perform(click());

        onView(withId(R.id.reset_button)).perform(click());
        onView(withId(R.id.turnNumber)).check(matches(withText("0")));
        onView(withId(R.id.img55)).check(matches(withDrawable(R.drawable.free4all0)));
        onView(withId(R.id.img54)).check(matches(withDrawable(R.drawable.free4all0)));
        onView(withId(R.id.img53)).check(matches(withDrawable(R.drawable.free4all0)));

    }
}