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
            when (theme) {
                Theme.LIGHT -> {
                    setTheme(AppCompatDelegate.MODE_NIGHT_NO, Theme.LIGHT)
                }
                Theme.DARK -> {
                    setTheme(AppCompatDelegate.MODE_NIGHT_YES, Theme.DARK)
                }
                else -> Unit
            }
        })
    }

    private fun setTheme(delegateNightMode: Int ,theme: Theme) {
        if (AppCompatDelegate.getDefaultNightMode() == delegateNightMode && currentTheme != theme) {
            recreate()
        } else {
            AppCompatDelegate.setDefaultNightMode(delegateNightMode)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                recreate()
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                recreate()
            }
        }
    }

    private fun initTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            currentTheme = Theme.DARK
            setTheme(R.style.DarkTheme)
        } else {
            currentTheme = Theme.LIGHT
            setTheme(R.style.LightTheme)
        }
    }
}
