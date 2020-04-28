package com.example.quickgrocery.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

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