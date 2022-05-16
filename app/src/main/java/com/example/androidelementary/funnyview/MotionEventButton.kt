package com.example.androidelementary.funnyview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by ypp on 2022/2/10
 */
class MotionEventView : View {

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {}

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> println("MotionEventButton---dispatchTouchEvent---DOWN")
            MotionEvent.ACTION_MOVE -> println("MotionEventButton---dispatchTouchEvent---MOVE")
            MotionEvent.ACTION_UP -> println("MotionEventButton---dispatchTouchEvent---UP")
            else -> {
            }
        }
        val dispatch = super.dispatchTouchEvent(event)
        println("MotionEventButton---dispatchTouchEvent-$dispatch")
        return dispatch
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> println("MotionEventButton---onTouchEvent---DOWN")
            MotionEvent.ACTION_MOVE -> println("MotionEventButton---onTouchEvent---MOVE")
            MotionEvent.ACTION_UP -> println("MotionEventButton---onTouchEvent---UP")
            else -> {
            }
        }
        val onTouchEvent = super.onTouchEvent(event)
        println("MotionEventButton---onTouchEvent-$onTouchEvent")
        return onTouchEvent
    }
}