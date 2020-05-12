package com.example.quickgrocery.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var themeDataSource: ThemeDataSource

    fun setTheme(theme: Theme) {
        themeDataSource.setTheme(theme)
    }

    @FlowPreview
    val theme: LiveData<Theme>
        get() = themeDataSource
            .getTheme()
            .asLiveData(viewModelScope.coroutineContext)
}
