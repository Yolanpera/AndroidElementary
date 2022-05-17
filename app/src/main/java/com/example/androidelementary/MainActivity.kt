package com.example.androidelementary

import android.app.Activity
import android.os.Bundle
import com.example.androidelementary.funnyview.FunnyViewActivity
import com.example.androidelementary.utils.registerChildActivity
import com.example.androidelementary.video.SeekBarTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moving_view.registerChildActivity(this, FunnyViewActivity::class.java)
        video.registerChildActivity(this, SeekBarTestActivity::class.java)
    }
}