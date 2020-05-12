package com.example.quickgrocery.common.application

import android.app.Application
import com.example.quickgrocery.common.di.ApplicationComponent
import com.example.quickgrocery.common.di.ApplicationModule
import com.example.quickgrocery.common.di.DaggerApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class QuickGroceryApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    private fun initDagger(app: QuickGroceryApplication): ApplicationComponent {
        return DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(app))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = initDagger(this)
    }
}
