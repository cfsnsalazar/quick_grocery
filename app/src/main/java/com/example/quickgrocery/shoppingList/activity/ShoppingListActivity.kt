package com.example.quickgrocery.shoppingList.activity

import android.content.Context
import android.content.Intent
import com.example.quickgrocery.R
import com.example.quickgrocery.meals.viewModel.MealsActivityViewModel
import com.example.quickgrocery.common.activity.BaseAuthenticatedActivity
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.common.viewModel.BaseViewModel
import com.example.quickgrocery.shoppingList.fragment.ShoppingListFragment
import com.example.quickgrocery.shoppingList.viewModel.ShoppingListActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class ShoppingListActivity : BaseAuthenticatedActivity() {
    override val viewModel: BaseViewModel
        get() = QuickGroceryViewModelProvider(this)
            .get(ShoppingListActivityViewModel::class.java)

    companion object {
        fun getBaseIntent(caller: Context): Intent {
            return Intent(caller, ShoppingListActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        }
    }

    override fun getMenuItem(): Int {
        return R.id.nav_shopping_list
    }

    override fun getMainFragment(): BaseFragment {
        return ShoppingListFragment.newInstance()
    }
}