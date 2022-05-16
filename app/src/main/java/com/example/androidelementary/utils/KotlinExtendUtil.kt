package com.example.androidelementary.utils

import android.view.View

/**
 * Created by ypp on 2022/4/22
 */
private var lastClickTime: Long = 0

private fun isFastDoubleClick(duration: Long = 500): Boolean {
    val time = System.currentTimeMillis()
    if (time - lastClickTime < duration) {
        return true
    }
    lastClickTime = time
    return false
}

fun View.setOnSingleClickListener(duration: Long = 500, listener: (View) -> Unit) = setOnClickListener {
    if (!isFastDoubleClick(duration)) {
        listener(it)
    }
}

