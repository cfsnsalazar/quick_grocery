package com.example.quickgrocery.settings.fragment

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.settings.viewModel.SettingsFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class SettingsFragmentViewModelTest: BaseViewModelTest() {
    override val viewModel: SettingsFragmentViewModel by lazy {
        SettingsFragmentViewModel()
    }
}