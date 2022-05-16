package com.example.androidelementary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.androidelementary.funnyview.FunnyViewActivity
import com.example.androidelementary.utils.setOnSingleClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moving_view_entrance.setOnSingleClickListener {
            val intent = Intent(this, FunnyViewActivity::class.java)
            startActivity(intent)
        }
    }
}