package com.example.quickgrocery.common.fragment

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.example.quickgrocery.common.application.QuickGroceryApplication
import com.example.quickgrocery.common.viewModel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
abstract class BaseFragment<T : BaseViewModel> : Fragment() {
    protected open val viewModel: T? by lazy {
        provideViewModel()
    }

    abstract fun provideViewModel(): T?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel?.let { baseViewModel ->
            (activity?.applicationContext as? QuickGroceryApplication)?.appComponent?.inject(
                baseViewModel
            )
        }
    }
}