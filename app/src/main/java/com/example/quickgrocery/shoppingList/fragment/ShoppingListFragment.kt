package com.example.quickgrocery.shoppingList.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickgrocery.R
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.shoppingList.viewModel.ShoppingListFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ShoppingListFragment: BaseFragment<ShoppingListFragmentViewModel>() {

    companion object{
        fun newInstance(): ShoppingListFragment{
            return ShoppingListFragment()
        }
    }

    override fun provideViewModel(): ShoppingListFragmentViewModel? {
        activity ?: return null
        return QuickGroceryViewModelProvider(activity!!).get(ShoppingListFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shopping_list, null);
    }
}