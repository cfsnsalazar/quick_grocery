package com.example.quickgrocery.common.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.ThemeDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

const val SHARED_PREFERENCES_NAME = "QuickGrocerySharedPreference"

@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun provideThemeDataSource(sharedPreferences: SharedPreferences): ThemeDataSource{
        return ThemeDataSource(sharedPreferences)
    }
}