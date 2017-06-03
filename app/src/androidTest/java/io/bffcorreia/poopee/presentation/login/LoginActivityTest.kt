package io.bffcorreia.poopee.presentation.login

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import android.support.test.uiautomator.Until
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import com.azimolabs.conditionwatcher.ConditionWatcher
import io.bffcorreia.poopee.AssertCurrentActivity.assertCurrentActivity
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.cards.CardsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class LoginActivityTest {

  @Rule @JvmField val activityRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

  @Test fun testActivityStarted() {
    assertCurrentActivity(LoginActivity::class.java)
  }

  @Test fun testLoginWithTestUser() {
    val email = "cristiano_kvhalvn_ronaldo@tfbnw.net"
    val password = "test1234"
    val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    val timeOut: Long = 1000 * 60

    onView(withId(R.id.login_button)).perform(click())
    device.wait(Until.findObject(By.clazz(WebView::class.java)), timeOut)

    val emailInput = device.findObject(UiSelector().instance(0).className(EditText::class.java))
    emailInput.waitForExists(timeOut)
    emailInput.legacySetText(email)

    val passwordInput = device.findObject(UiSelector().instance(1).className(EditText::class.java))
    passwordInput.waitForExists(timeOut)
    passwordInput.legacySetText(password)

    val buttonLogin = device.findObject(UiSelector().instance(0).className(Button::class.java))
    buttonLogin.waitForExists(timeOut)
    buttonLogin.clickAndWaitForNewWindow()

    val buttonOk = device.findObject(UiSelector().instance(1).className(Button::class.java))
    buttonOk.waitForExists(timeOut)
    buttonOk.click()

    ConditionWatcher.waitForCondition(AuthInstruction(activityRule.activity))
    assertCurrentActivity(CardsActivity::class.java)
  }
}