package com.example.quickgrocery.common.di

import com.example.quickgrocery.common.viewModel.BaseViewModel
import dagger.Component
import javax.inject.Singleton
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)

@ExperimentalCoroutinesApi
interface ApplicationComponent {
    fun inject(target: BaseViewModel)
}
