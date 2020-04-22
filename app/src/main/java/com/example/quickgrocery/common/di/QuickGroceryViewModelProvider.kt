package com.example.quickgrocery.common.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class QuickGroceryViewModelProvider(
    owner: ViewModelStoreOwner
) : ViewModelProvider(owner) {

    companion object {
        fun <T : ViewModel?> Class<T>.createTypeSafeId(key: String): String {
            return key + this.canonicalName
        }
    }

    override fun <T : ViewModel?> get(key: String, modelClass: Class<T>): T {
        val typeSafeId = modelClass.createTypeSafeId(key)
        return super.get(typeSafeId, modelClass)
    }
}