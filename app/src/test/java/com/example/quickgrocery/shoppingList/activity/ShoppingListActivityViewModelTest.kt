package com.example.quickgrocery.shoppingList.activity

import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.shoppingList.viewModel.ShoppingListActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class ShoppingListActivityViewModelTest: BaseViewModelTest() {
    override val viewModel: ShoppingListActivityViewModel by lazy {
        ShoppingListActivityViewModel()
    }
}