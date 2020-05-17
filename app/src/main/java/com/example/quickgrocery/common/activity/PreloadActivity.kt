package com.example.quickgrocery.common.activity

import android.os.Bundle
import com.example.quickgrocery.R
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.viewModel.PreloadViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class PreloadActivity: BaseActivity() {
    override val viewModel: PreloadViewModel
        get() = QuickGroceryViewModelProvider(this).get(PreloadViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)
    }
}