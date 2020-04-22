package com.example.quickgrocery.common.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private var themeDataSource: ThemeDataSource? = null

    @ExperimentalCoroutinesApi
    @FlowPreview
    fun init(sharedPreferences: SharedPreferences){
        this.themeDataSource = ThemeDataSource(sharedPreferences)
        _theme = themeDataSource
            ?.getTheme()
            ?.asLiveData(viewModelScope.coroutineContext)
    }

    private var _theme: LiveData<Theme>? = null

    @ExperimentalCoroutinesApi
    fun setTheme(theme: Theme) {
        themeDataSource?.setTheme(theme)
    }

    @ExperimentalCoroutinesApi
    val theme: LiveData<Theme>?
        get() = _theme
}