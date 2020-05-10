package com.example.quickgrocery.meals.activity

import TestApplicationModule
import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import com.example.quickgrocery.common.TestCoroutineRule
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import com.example.quickgrocery.meals.viewModel.MealsActivityViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
@FlowPreview
class MealsActivityViewModelTest {

    @get: Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @get: Rule
    val testCoroutineRule = TestCoroutineRule()
    @Inject
    lateinit var themeDataSource: ThemeDataSource

    lateinit var mealsActivityViewModel: MealsActivityViewModel

    @Before
    fun setUp(){
     val component = DaggerTestApplicationComponent
         .builder()
         .applicationModule(TestApplicationModule(Application()))
         .build()

        mealsActivityViewModel = MealsActivityViewModel()
        component.inject(this)
        component.inject(mealsActivityViewModel)
    }

    @Test
    fun test_dark_theme(){
        testCoroutineRule.runBlockingTest {
            val data = MutableLiveData<Theme>()
            data.postValue(Theme.DARK)
            Mockito.doReturn(data.asFlow()).`when`(themeDataSource).getTheme()
            assertEquals(mealsActivityViewModel.theme.getValueSynchronously(), Theme.DARK)
        }
    }
}

fun <T> LiveData<T>.getValueSynchronously(): T?{
    var value: T? = null
    observeForever { newValue -> value = newValue }
    return value
}