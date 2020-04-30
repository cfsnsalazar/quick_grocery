package com.example.quickgrocery.settings.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import com.example.quickgrocery.R
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.activity.BaseAuthenticatedActivity
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.common.viewModel.BaseViewModel
import com.example.quickgrocery.settings.fragment.SettingsFragment
import com.example.quickgrocery.settings.viewModel.SettingsActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class SettingsActivity: BaseAuthenticatedActivity(), SettingsFragment.FragmentListener {
    companion object {
        fun getBaseIntent(caller: Context): Intent {
            return Intent(caller, SettingsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        }
    }

    override fun getMenuItem(): Int {
        return R.id.nav_settings
    }

    override fun getMainFragment(): BaseFragment<*> {
        return SettingsFragment.newInstance()
    }

    override val viewModel: BaseViewModel
        get() = QuickGroceryViewModelProvider(this)
            .get(SettingsActivityViewModel::class.java)

    override fun onThemeChanged(theme: Theme) {
        viewModel.setTheme(theme)
    }
}