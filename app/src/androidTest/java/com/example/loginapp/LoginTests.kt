package com.example.loginapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.loginapp.ui.login.LoginActivity
import org.hamcrest.CoreMatchers.not

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test fun checkLoginButtonIsUnable() {
        onView(withId(R.id.login)).check(matches(not(isEnabled())))
    }

    @Test fun checkLoginButtonIsUnableWithoutPasswordByPO() {
        LoginPage().setUserName("Vladimir")
            .checkLoginButtonIsDisable()
    }

    @Test fun checkLoginButtonIsEnableWithPasswordByPO() {
        LoginPage().setUserName("Vladimir")
            .setPassword("qwerty")
            .checkLoginButtonIsEnable()
    }


}
