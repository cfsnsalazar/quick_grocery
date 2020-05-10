package com.example.quickgrocery.settings.activity

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.settings.viewModel.SettingsActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class SettingsActivityViewModelTest: BaseViewModelTest() {
    override val viewModel: SettingsActivityViewModel by lazy {
        SettingsActivityViewModel()
    }
}