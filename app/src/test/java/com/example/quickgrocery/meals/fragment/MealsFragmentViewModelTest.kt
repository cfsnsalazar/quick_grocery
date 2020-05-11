package com.example.quickgrocery.meals.fragment

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.meals.viewModel.MealsFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MealsFragmentViewModelTest : BaseViewModelTest() {
    override val viewModel: MealsFragmentViewModel by lazy {
        MealsFragmentViewModel()
    }
}
