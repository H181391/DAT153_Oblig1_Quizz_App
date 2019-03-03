package com.example.sondre.oblig_1_name_quizz



import android.app.PendingIntent.getActivity

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.intent.Intents.intending
import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.support.test.InstrumentationRegistry


//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.Espresso.*
//import androidx.test.runner.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
@LargeTest
class UiTest {

    private lateinit var stringToBetyped: String

    var db: AppDatabase = AppDatabase.getInstance(InstrumentationRegistry.getTargetContext())!!
    val personList: List<Person>? = db?.personDao()?.getAll()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)
    /*var activityRule: ActivityTestRule<QuizActivity>
            = ActivityTestRule(QuizActivity::class.java)
            */
    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso"
    }



    @Test
    fun goToStartGameAndTestAnswer () {

        onView(withId(R.id.start)).perform(click())

        //Når databasen er tom, er det ikke mulig å starte en quiz
        if (personList?.size == 0) {
            onView(withId(R.id.startImage)).check(matches(isDisplayed()))
        } else {


            onView(withId(R.id.answer)).perform(typeText("Door"))

            closeSoftKeyboard()

            onView(withId(R.id.submit)).perform(click())

            //Databasen består a en person
            if (personList?.size == 1) {
                if ((personList?.get(0)?.first_name).equals("Door") == true){
                    onView(withText(R.string.correctAnswer)).inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                        .check(matches(isDisplayed()))
                } else {
                    onView(withText(R.string.gameFinished)).inRoot(withDecorView(not(activityRule.activity.window.decorView)))
                }
            //Databasen består av mer enn 1 person
            } else {
                onView(withText(R.string.gameFinished)).inRoot(withDecorView(not(activityRule.activity.window.decorView))).check(
                    matches(isDisplayed()))
            }

        }

    }


}