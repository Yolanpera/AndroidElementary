package com.example.androidelementary.funnyview

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidelementary.R
import com.example.androidelementary.bezier.BezierInterpolator
import com.example.androidelementary.utils.setOnSingleClickListener
import kotlinx.android.synthetic.main.activity_funny_view.*


class FunnyViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funny_view)
        down_button.setOnSingleClickListener {
            showDownAnimation(it)
        }
        motion_view.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> println("motion_view---onTouch---DOWN")
                MotionEvent.ACTION_MOVE -> println("motion_view---onTouch---MOVE")
                MotionEvent.ACTION_UP -> println("motion_view---onTouch---UP")
                else -> {
                }
            }
            false
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> println("Activity---dispatchTouchEvent---DOWN")
            MotionEvent.ACTION_MOVE -> println("Activity---dispatchTouchEvent---MOVE")
            MotionEvent.ACTION_UP -> println("Activity---dispatchTouchEvent---UP")
            else -> {
            }
        }
        val dispatch = super.dispatchTouchEvent(event)
        println("Activity---dispatch-$dispatch")
        return dispatch
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> println("Activity---onTouchEvent---DOWN")
            MotionEvent.ACTION_MOVE -> println("Activity---onTouchEvent---MOVE")
            MotionEvent.ACTION_UP -> println("Activity---onTouchEvent---UP")
            else -> {
            }
        }
        val onTouchEvent = super.onTouchEvent(event)
        println("Activity---onTouchEvent-$onTouchEvent")
        return onTouchEvent
    }

    private fun showDownAnimation(view: View) {
        //这里奇怪的是 再次点击 button，不会移动了.断点发现 view.bottom 不会因为属性动画而改变
        val lastY = view.bottom
        val translationY = 100f
        val mBezierInterpolator = BezierInterpolator(0.65F, 0F, 0.35F, 1F)
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, translationY).apply {
            duration = 400
            interpolator = mBezierInterpolator
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {}

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {}

            })
        }
        objectAnimator.start()
    }





}