package com.example.androidelementary.jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidelementary.R
import kotlinx.android.synthetic.main.activity_click.*


class ClickActivity : AppCompatActivity() {

    lateinit var viewModel: ClickModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)
        viewModel = ViewModelProvider(this).get(ClickModel::class.java)
        plusOneBtn.setOnClickListener {
            viewModel.count++
            refreshCount()
        }
        refreshCount()
    }

    private fun refreshCount() {
        infoText.text = viewModel.count.toString()
    }
}