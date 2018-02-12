package pe.tohure.designpatternswithtests.ui.customeraccount;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pe.tohure.desingpatternswithtests.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static pe.tohure.designpatternswithtests.util.HelperTest.childAtPosition;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CustomerAccountInstrumentedTest {

    private CustomerAccountActivity activity;

    @Rule
    public ActivityTestRule<CustomerAccountActivity> mActivityTestRule = new ActivityTestRule<>(CustomerAccountActivity.class);

    @Before
    public void Setup() {
        activity = mActivityTestRule.getActivity();
    }

    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("pe.tohure.desingpatternswithtests", appContext.getPackageName());
    }

    @Test
    public void scrollAtFinalTest() {
        int finalPosition = activity.rvCustomerAccount.getAdapter().getItemCount() - 1;

        onView(withId(R.id.rvCustomerAccount))
                .perform(RecyclerViewActions
                        .scrollToPosition(finalPosition));
    }

    @Test
    public void clickFirstItemTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvCustomerAccount),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    @Test
    public void pressBackTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvCustomerAccount),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(5, click()));

        pressBack();
    }

    @Test
    public void verifyTextValuesTest() {
        ViewInteraction recyclerView = onView(
                Matchers.allOf(withId(R.id.rvCustomerAccount),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(6, click()));

        ViewInteraction textView = onView(
                Matchers.allOf(withId(R.id.lblName), withText("Mi septimo sueldo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Mi septimo sueldo")));

        ViewInteraction textView2 = onView(
                Matchers.allOf(withId(R.id.lblMount), withText("S/. 77208"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("S/. 77208")));

        ViewInteraction textView3 = onView(
                Matchers.allOf(withId(R.id.lblAvailable), withText("Saldo no disponible"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Saldo no disponible")));

    }

}
