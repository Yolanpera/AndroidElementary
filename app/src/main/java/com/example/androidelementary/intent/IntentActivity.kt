package com.example.androidelementary.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidelementary.R
import com.example.androidelementary.recyclerview.GridRecyclerViewActivity

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
    }

    override fun onResume() {
        super.onResume()
        Intent(this, GridRecyclerViewActivity::class.java).run {
            startActivity(this)
        }
    }
}