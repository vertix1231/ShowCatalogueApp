package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.DataDummy
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest : TestCase() {

    private val dummyCourseMovie = DataDummy.generateDataMovieDummy()
    private val dummyCourseTvshow = DataDummy.generateDataTvShowDummy()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    //framgent MOVIE
    @Test
    fun loadCoursesMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourseMovie.size))

    }
    @Test
    fun loadModuleMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyCourseMovie[0].name)))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyCourseMovie[0].desc)))
    }

    //framgent TVSHOW
    @Test
    fun loadCoursesTvshow() {
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourseTvshow.size))
    }
    @Test
    fun loadModuleTvshow() {
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyCourseMovie[0].name)))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyCourseMovie[0].desc)))

    }

//    @Test
//    fun loadDetailCourseMovie() {
//        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyCourseMovie[0].name)))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText("DescMovie ${dummyCourseMovie[0].desc}")))
//        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
//        onView(withId(R.id.img_detail_poster)).check(matches(withText(dummyCourseMovie[0].poster)))
//        onView(withId(R.id.img_detail_hightlight)).check(matches(isDisplayed()))
//        onView(withId(R.id.img_detail_poster)).check(matches(withText(dummyCourseMovie[0].img_preview)))
//
//    }

//    @Test
//    fun loadDetailCourseTvshow() {
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyCourseMovie[0].name)))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText("DescTvshow ${dummyCourseMovie[0].desc}")))
//        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
//        onView(withId(R.id.img_detail_poster)).check(matches(withText(dummyCourseMovie[0].poster)))
//        onView(withId(R.id.img_detail_hightlight)).check(matches(isDisplayed()))
//        onView(withId(R.id.img_detail_poster)).check(matches(withText(dummyCourseMovie[0].img_preview)))
//    }


//    @Test
//    fun loadTvshow() {
//        onView(withText("Tvshow")).perform(click())
//        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourseTvshow.size))
//    }

//    fun testOnCreate() {}
}