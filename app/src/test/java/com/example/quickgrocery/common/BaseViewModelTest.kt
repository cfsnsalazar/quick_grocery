package com.example.quickgrocery.common

import TestApplicationModule
import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.quickgrocery.common.viewModel.BaseViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@FlowPreview
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
abstract class BaseViewModelTest {
    @get: Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @get: Rule
    val testCoroutineRule = TestCoroutineRule()
    @Inject
    lateinit var themeDataSource: ThemeDataSource
    abstract val viewModel: BaseViewModel

    @Before()
    fun setUp() {
        val component = DaggerTestApplicationComponent
            .builder()
            .applicationModule(TestApplicationModule(Application()))
            .build()
        component.inject(this)
        component.inject(viewModel)
    }

    @Test
    fun appTheme_shouldBeSystem() {
        testCoroutineRule.runBlockingTest {
            val data = MutableLiveData<Theme>()
            data.postValue(Theme.SYSTEM)
            Mockito.doReturn(data.asFlow()).`when`(themeDataSource).getTheme()
            Assert.assertEquals(viewModel.theme.getValueSynchronously(), Theme.SYSTEM)
        }
    }

    @Test
    fun appTheme_shouldBeDark() {
        testCoroutineRule.runBlockingTest {
            val data = MutableLiveData<Theme>()
            data.postValue(Theme.DARK)
            Mockito.doReturn(data.asFlow()).`when`(themeDataSource).getTheme()
            Assert.assertEquals(viewModel.theme.getValueSynchronously(), Theme.DARK)
        }
    }

    @Test
    fun appTheme_shouldBeLight() {
        testCoroutineRule.runBlockingTest {
            val data = MutableLiveData<Theme>()
            data.postValue(Theme.LIGHT)
            Mockito.doReturn(data.asFlow()).`when`(themeDataSource).getTheme()
            Assert.assertEquals(viewModel.theme.getValueSynchronously(), Theme.LIGHT)
        }
    }
}
