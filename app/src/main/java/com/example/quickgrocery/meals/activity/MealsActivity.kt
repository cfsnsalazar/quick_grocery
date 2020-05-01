package com.example.quickgrocery.meals.activity

import android.content.Context
import android.content.Intent
import com.example.quickgrocery.R
import com.example.quickgrocery.meals.viewModel.MealsActivityViewModel
import com.example.quickgrocery.common.activity.BaseAuthenticatedActivity
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.common.viewModel.BaseViewModel
import com.example.quickgrocery.meals.fragment.MealsFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MealsActivity : BaseAuthenticatedActivity() {

    companion object {
        fun getBaseIntent(caller: Context): Intent {
            return Intent(caller, MealsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        }
    }

    override fun getMenuItem(): Int {
        return R.id.nav_meal_schedule
    }

    override fun getMainFragment(): BaseFragment {
       return MealsFragment.newInstance()
    }

    override val viewModel: BaseViewModel
        get() = QuickGroceryViewModelProvider(this)
            .get(MealsActivityViewModel::class.java)
}