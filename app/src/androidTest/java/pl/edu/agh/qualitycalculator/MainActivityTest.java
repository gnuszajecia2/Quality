package pl.edu.agh.qualitycalculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testSum(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("4"));
        onView(withId(R.id.etNum2)).perform(click()).perform(typeText("4"));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("4.0 plus 4.0 gives value 8.0")));
       }

    @Test
    public void testSumNull(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("4"));
        onView(withId(R.id.etNum2)).perform(click()).perform(typeText(""));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("Enter some data to calculate")));
    }



    //Testy dzielenie


    @Test
    public void testDivide(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("4"));
        onView(withId(R.id.etNum2)).perform(click()).perform(typeText("4"));
        onView(withId(R.id.btnDiv)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("4.0 divided by 4.0 gives value 1.0")));
    }

    @Test
    public void testAverage(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("1"));
        onView(withId(R.id.etNum2)).perform(click()).perform(typeText("3"));
        onView(withId(R.id.etNum3)).perform(click()).perform(typeText("5"));
        onView(withId(R.id.btnAvg)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("Average of 1.0, 3.0, 5.0 gives value 3.0")));
    }

    @Test
    public void longMessage(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("1"));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("Populate first two fields to perform +, -, * or /. \n Populate all three to calculate average.")));
    }

    @Test
    public void shortMessage(){
        onView(withId(R.id.etNum1)).perform(click()).perform(typeText("1"));
        onView(withId(R.id.etNum2)).perform(click()).perform(typeText("3"));
        onView(withId(R.id.btnAvg)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("Populate all three fields to calculate average")));
    }

}

