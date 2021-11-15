package com.example.androidelementary.recyclerview.mode

import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by ypp on 2021/9/6
 */
class BlankLinearSnapHelper: LinearSnapHelper() {
    private var mListener: OnItemSelectedListener? = null

    public fun setOnItemSelectedListener(listener: OnItemSelectedListener) {
        mListener = listener
    }

    public fun notifyItemSelected(view: View, position: Int) {
        mListener?.onItemSelected(view, position)
    }

    override fun findSnapView(layoutManager: RecyclerView.LayoutManager?): View? {
        var finalPosition = -1
        super.findSnapView(layoutManager)?.apply {
            val
        }

    }
}

interface OnItemSelectedListener {
    fun onItemSelected(view: View, position: Int) {

    }
}