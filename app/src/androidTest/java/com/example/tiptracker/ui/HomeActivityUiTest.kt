package com.example.tiptracker.ui.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.recyclerview.widget.RecyclerView
import com.example.tiptracker.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityUiTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun addTip_showsInRecyclerView() {
        // 1. Click FAB (+)
        onView(withId(R.id.fabAddTip)).perform(click())

        // 2. Type a number
        onView(withId(R.id.etAmount)).perform(typeText("12.50"))
        closeSoftKeyboard()

        // 3. Save
        onView(withId(R.id.btnSave)).perform(click())

        // 4. Check if recycler view has at least 1 item
        onView(withId(R.id.rvTips))
            .check(matches(hasMinimumChildCount(1)))
    }
}
