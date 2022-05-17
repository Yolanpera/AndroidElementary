package com.example.androidelementary.video

import android.os.Bundle
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.androidelementary.R
import kotlinx.android.synthetic.main.activity_seek_bar_test.*

class SeekBarTestActivity : AppCompatActivity() {

    private var originProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_test)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        initView()
    }

    private fun initView() {
        seek_Bar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                originProgress = seekBar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (seekBar.progress < originProgress) {
                    //返回
                    seekBar.progress = originProgress
                }
            }
        })
    }

}