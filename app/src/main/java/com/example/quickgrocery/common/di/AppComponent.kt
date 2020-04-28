package com.example.quickgrocery.common.di

import com.example.quickgrocery.common.viewModel.BaseViewModel
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])

@ExperimentalCoroutinesApi
interface AppComponent {
    fun inject(target: BaseViewModel)
}