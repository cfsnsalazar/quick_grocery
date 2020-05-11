package com.example.quickgrocery.meals.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickgrocery.R
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.meals.viewModel.MealsFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MealsFragment : BaseFragment() {

    companion object {
        fun newInstance(): MealsFragment {
            return MealsFragment()
        }
    }

    override val viewModel: MealsFragmentViewModel by lazy {
        QuickGroceryViewModelProvider(activity!!).get(MealsFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meals, null)
    }
}
