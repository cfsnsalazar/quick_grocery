package com.example.quickgrocery.common

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.getValueSynchronously(): T? {
    var value: T? = null
    observeForever { newValue -> value = newValue }
    return value
}
