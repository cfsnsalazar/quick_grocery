package com.example.quickgrocery.shoppingList.fragment

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.shoppingList.viewModel.ShoppingListFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class ShoppingListFragmentViewModelTest: BaseViewModelTest() {
    override val viewModel: ShoppingListFragmentViewModel by lazy {
        ShoppingListFragmentViewModel()
    }
}