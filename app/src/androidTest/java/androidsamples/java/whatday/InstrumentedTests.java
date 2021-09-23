package androidsamples.java.whatday;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented tests for the {@link MainActivity} behavior.
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {
  @Rule
  public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

  @Test
  public void Aug15_1947_Friday() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("15"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("8"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1947"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Friday")));
  }

  @Test
  public void test42isInvalidDate() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("42"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("8"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Invalid date")));
  }

  /* Personal Test Cases Begin Here*/
  @Test
  public void test30inFebruary() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("30"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("This month does not have 30 days")));
  }

  @Test
  public void testInvalidYear() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("17"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("-800"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Invalid year")));
  }

  @Test
  public void testInvalidYearAndInvalidMonth() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("17"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("19"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("-800"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Invalid year")));
  }

  @Test
  public void test29inLeapYear() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2020"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Saturday")));
  }

  @Test
  public void test29inNonLeapYear() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2022"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("February of 2022 does not have 29 days")));
  }

  @Test
  public void test29inMultipleOf100ButNot400() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1900"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("February of 1900 does not have 29 days")));
  }

  @Test
  public void test2of29inMultipleOf100ButNot400() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1800"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("February of 1800 does not have 29 days")));
  }

  @Test
  public void test29inMultipleOf400() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2000"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Tuesday")));
  }

  @Test
  public void testInvalidDateFormat() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29.433"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1600"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Enter values in a proper numeric format")));
  }

  @Test
  public void testInvalidMonthFormat() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("2.5"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1600"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Enter values in a proper numeric format")));
  }

  @Test
  public void testInvalidMonth() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("29"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("13"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1600"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Invalid month")));
  }

  @Test
  public void testCheck30DaysOr31() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("31"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("9"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("This month does not have 31 days")));
  }

  @Test
  public void test2ofCheck30DaysOr31() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("31"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("7"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Saturday")));
  }

  @Test
  public void test3ofCheck30DaysOr31() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("31"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("8"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Tuesday")));
  }
}