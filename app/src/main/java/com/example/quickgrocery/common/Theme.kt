package com.example.quickgrocery.common

import androidx.appcompat.app.AppCompatDelegate
import com.example.quickgrocery.R

enum class Theme(val appCompatDelegateValue: Int, val style: Int, val stringResource: Int) {
    SYSTEM(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, -1, R.string.theme_system),
    LIGHT(AppCompatDelegate.MODE_NIGHT_NO, R.style.LightTheme, R.string.theme_light),
    DARK(AppCompatDelegate.MODE_NIGHT_YES, R.style.DarkTheme, R.string.theme_dark);

    companion object {
        fun fromAppCompatDelegate(appCompatDelegateValue: Int): Theme {
            values().forEach { theme ->
                if (theme.appCompatDelegateValue == appCompatDelegateValue) {
                    return theme
                }
            }
            return LIGHT
        }
    }
}
