package com.example.quickgrocery.common.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.quickgrocery.common.application.QuickGroceryApplication
import com.example.quickgrocery.common.viewModel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BaseFragment : Fragment() {
    abstract val viewModel: BaseViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as? QuickGroceryApplication)?.applicationComponent?.inject(viewModel)
    }
}
