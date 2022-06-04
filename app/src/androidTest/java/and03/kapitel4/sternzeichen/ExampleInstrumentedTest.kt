package and03.kapitel4.sternzeichen

import android.view.View
import android.widget.NumberPicker
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val myActivityRule= ActivityTestRule(MainActivity::class.java)//ActivityTestRule(MainActivity::class.java) //Klassenimport über dependencies im Project Structure hinzufügen

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("and03.kapitel4.sternzeichen", appContext.packageName)
    }

    @Test
    fun textView_atStart() {
        onView(withId(R.id.textview_ausgabe)).check(matches(withText("Wähle deinen Geburtstag!")))
        /*Am Aufruf
        onView(withId(R.id.textview_ausgabe)).check(matches(withText("Wähle Deinen Geburtstag")))
        sind die folgenden Methoden beteiligt:

        ViewInteraction onView(Matcher<View> ViewMatcher)
        Klasse android.support.test.espresso.Espresso

        Matcher<View> withId(int id)
        Klasse android.support.test.espresso.matcher. ViewMatchers

        ViewInteraction check(ViewAssertion viewAssert)
        Klasse android.support.test.espresso.ViewInteraction

        ViewAssertion matches(Matcher<? super View> viewMatcher)
        Klasse android.support.test.espresso.assertion. ViewAssertions

        Matcher<View> withText(String text)
        Klasse android.support.test.espresso.matcher. ViewMatchers

        Die Programmzeile kann somit wie folgt in einzelne Bestandteile „zerlegt“ werden:
        val interaction = withText("Wähle Deinen Geburtstag")
        val viewAssertion = matches(interaction)
        val viewMatcher = withId(R.id.textview_ausgabe)
        val view = onView(viewMatcher)
        view.check(viewAssertion) */
    }
    //1. Januar Test (voreingestellt)
    @Test
    fun textView_at1Januar() {
        onView(withId(R.id.button_ok)).perform(click())
        onView(withId(R.id.textview_ausgabe)).check(matches(withText("Dein Sternzeichen ist Steinbock")))
    }

    //1. Dezember Test (Spinner)
    @Test
    fun textView_at1Dezember() {
        onView(withId(R.id.spinner_monat)).perform(click())
        onData(`is`("Dezember")).perform(click())
        onView(withId(R.id.button_ok)).perform(click())
        onView(withId(R.id.textview_ausgabe)).check(matches(withText("Dein Sternzeichen ist Schütze")))
    }

    //NumberPicker Test
    @Test
    fun textView_at31Dezember() {
        onView(withId(R.id.spinner_monat)).perform(click())
        onData(`is`("Dezember")).perform(click())
        onView(withId(R.id.numberpicker_tag)).perform(setValue(31))
        onView(withId(R.id.button_ok)).perform(click())
        onView(withId(R.id.textview_ausgabe)).check(matches(withText("Dein Sternzeichen ist Steinbock")))
    }
    //MaxValue Test
    @Test
    fun numberPicker_maxValueFebruar() {
        onView(withId(R.id.spinner_monat)).perform(click())
        onData(`is`("Februar")).perform(click())
        onView(withId(R.id.numberpicker_tag)).check(testMaxValue(29))
    }

    fun setValue(value: Int): ViewAction {
        return object: ViewAction {
            override fun perform(uiController: UiController?, view: View?) {
                (view as NumberPicker).value = value
            }

            override fun getDescription(): String {
                return "Set the passed value into the NumberPicker"
            }

            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(NumberPicker::class.java)
            }
        }
    }

    fun testMaxValue(maxValue: Int) : ViewAssertion {
        return object: ViewAssertion {
            override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
                if (maxValue != (view as NumberPicker).maxValue)
                    throw junit.framework.AssertionFailedError()
            }

        }
    }
}