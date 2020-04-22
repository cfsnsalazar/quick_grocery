package com.example.quickgrocery.common.application

import android.app.Application
import com.example.quickgrocery.common.di.AppComponent
import com.example.quickgrocery.common.di.AppModule
import com.example.quickgrocery.common.di.DaggerAppComponent

class QuickGroceryApplication : Application() {
    lateinit var appComponent: AppComponent

    private fun initDagger(app: QuickGroceryApplication): AppComponent {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(app))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }
}