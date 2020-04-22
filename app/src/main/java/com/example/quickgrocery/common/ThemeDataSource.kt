package com.example.quickgrocery.common

import android.content.SharedPreferences
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

val PREFERENCE_KEY_THEME = "preference_key_theme"

class ThemeDataSource(
    private val sharedPreferences: SharedPreferences
) {
    @ExperimentalCoroutinesApi
    private val themeChannel: ConflatedBroadcastChannel<Theme> by lazy {
        ConflatedBroadcastChannel<Theme>().also { channel ->
            val theme = sharedPreferences.getString(
                PREFERENCE_KEY_THEME,
                null
            ) ?: Theme.LIGHT.name //Default theme is light
            channel.offer(Theme.valueOf(theme))
        }
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    fun getTheme(): Flow<Theme> {
        return themeChannel.asFlow()
    }

    @ExperimentalCoroutinesApi
    fun setTheme(theme: Theme){
        sharedPreferences
            .edit()
            .putString(PREFERENCE_KEY_THEME, theme.name)
            .apply()
        themeChannel.offer(theme)
    }
}