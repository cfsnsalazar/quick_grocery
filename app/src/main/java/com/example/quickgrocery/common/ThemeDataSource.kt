package com.example.quickgrocery.common

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

const val PREFERENCE_KEY_THEME = "preference_key_theme"

@ExperimentalCoroutinesApi
open class ThemeDataSource(
    private val sharedPreferences: SharedPreferences
) {

    private val themeChannel: ConflatedBroadcastChannel<Theme> by lazy {
        ConflatedBroadcastChannel<Theme>().also { channel ->
            val theme = sharedPreferences.getString(
                PREFERENCE_KEY_THEME,
                null
            ) ?: Theme.SYSTEM.name
            channel.offer(Theme.valueOf(theme))
        }
    }

    @FlowPreview
    open fun getTheme(): Flow<Theme> {
        return themeChannel.asFlow()
    }

    fun setTheme(theme: Theme){
        sharedPreferences
            .edit()
            .putString(PREFERENCE_KEY_THEME, theme.name)
            .apply()
        themeChannel.offer(theme)
    }
}