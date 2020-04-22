package com.example.quickgrocery.common.di

import com.example.quickgrocery.common.ThemeDataSource
import com.example.quickgrocery.common.activity.MainActivity
import com.example.quickgrocery.common.viewModel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: ThemeDataSource)
    fun inject(target: MainViewModel)
}