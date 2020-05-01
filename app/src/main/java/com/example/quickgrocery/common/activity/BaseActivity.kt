package com.example.quickgrocery.common.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.example.quickgrocery.R
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.application.QuickGroceryApplication
import com.example.quickgrocery.common.viewModel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
abstract class BaseActivity : AppCompatActivity() {
    abstract val viewModel: BaseViewModel
    lateinit var currentTheme: Theme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as QuickGroceryApplication).appComponent.inject(viewModel)
        initTheme()
        initObservers()
    }

    protected open fun initObservers() {
        viewModel.theme.observe(this, Observer { theme ->
            if (AppCompatDelegate.getDefaultNightMode() == theme.appCompatDelegateValue && currentTheme != theme) {
                recreate()
            } else {
                AppCompatDelegate.setDefaultNightMode(theme.appCompatDelegateValue)
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val uiMode = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if(uiMode == Configuration.UI_MODE_NIGHT_YES || uiMode == Configuration.UI_MODE_NIGHT_NO){
            recreate()
        }
    }

    private fun initTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
            || AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
            initThemeFromSystem()
            return
        }
        initThemeBasedOnAppCompat()
    }

    private fun initThemeFromSystem() {
        currentTheme = Theme.SYSTEM
        val uiMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        setTheme(if (uiMode == Configuration.UI_MODE_NIGHT_YES) R.style.DarkTheme else R.style.LightTheme)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun initThemeBasedOnAppCompat() {
        currentTheme = Theme.fromAppCompatDelegate(AppCompatDelegate.getDefaultNightMode())
        setTheme(currentTheme.style)
    }
}
