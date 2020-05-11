package com.example.quickgrocery.meals.activity

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.meals.viewModel.MealsActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class MealsActivityViewModelTest : BaseViewModelTest() {
    override val viewModel: MealsActivityViewModel by lazy {
        MealsActivityViewModel()
    }
}
