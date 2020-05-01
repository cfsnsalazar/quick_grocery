package com.example.quickgrocery.meals.activity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.quickgrocery.common.TestCoroutineRule
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import com.example.quickgrocery.meals.viewModel.MealsActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
@FlowPreview
class MealsActivityViewModelTest {
    @get: Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @get: Rule
    val testCoroutineRule = TestCoroutineRule()
    @Mock
    private lateinit var themeDataSource: ThemeDataSource


    @Before
    fun setUp(){

    }

    @Test
    fun test_dark_theme(){
//        testCoroutineRule.runBlockingTest {
//            val themeLiveData = MutableLiveData<Theme>()
//            themeLiveData.postValue(Theme.DARK)
//            doReturn(themeLiveData.asFlow())
//                .`when`(themeDataSource.getTheme())
//
//        }
    }

    @After
    fun tearDown(){

    }
}