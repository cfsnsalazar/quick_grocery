package com.example.quickgrocery.common.activity

import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import com.example.quickgrocery.R
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.application.QuickGroceryApplication
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.viewModel.MainViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel: MainViewModel by lazy {
        QuickGroceryViewModelProvider(this).get(MainViewModel::class.java)
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }
        setContentView(R.layout.activity_main)
        nvMenu.setNavigationItemSelectedListener(this)
        initToolbar()

        (applicationContext as QuickGroceryApplication).appComponent.inject(this)
        viewModel.init(sharedPreferences)
        initTheme()
    }

    @ExperimentalCoroutinesApi
    private fun initTheme() {
        btnDarkTheme.setOnClickListener {
            viewModel.setTheme(Theme.DARK)
        }

        btnLightTheme.setOnClickListener {
            viewModel.setTheme(Theme.LIGHT)
        }

        observeTheme()
    }

    private fun initToolbar() {
        setSupportActionBar(ctAppToolbar.tbAppToolbar)
        ctAppToolbar.tbAppToolbar.setNavigationOnClickListener {
            dlMain.openDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_meal_schedule -> {

            }
            R.id.nav_shopping_list -> {

            }
        }

        nvMenu.setCheckedItem(item.itemId)
        dlMain.closeDrawer(GravityCompat.START)
        return true
    }

    @ExperimentalCoroutinesApi
    private fun observeTheme() {
        viewModel.theme?.observe(this, Observer { theme ->
            when (theme) {
                Theme.LIGHT -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                Theme.DARK -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                else -> Unit
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val currentNightMode = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                recreate()
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                recreate()
            }
        }
    }
}
