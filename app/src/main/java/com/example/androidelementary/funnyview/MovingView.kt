package com.example.androidelementary.funnyview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by ypp on 2022/4/21
 */
class MovingView : View {

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private var lastX = 0
    private var lastY = 0
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动距离
                val offsetX = x - lastX
                val offsetY = y - lastY
                //重新绘制
                layout(left + offsetX, top + offsetY, right + offsetX, bottom + offsetY)
            }
        }
        return true
    }
}