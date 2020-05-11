package com.example.quickgrocery.common.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.quickgrocery.R

class CustomToolbar(context: Context, attrs: AttributeSet) : CoordinatorLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this, true)
    }
}
