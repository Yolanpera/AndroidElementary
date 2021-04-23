package com.example.androidelementary.viewgroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidelementary.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_collapsing_toolbar.*

class CollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)

        appbar_layout.addOnOffsetChangedListener(object :AppBarLayout.OnOffsetChangedListener{
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                text_title.alpha =  -verticalOffset.toFloat() / appbar_layout.totalScrollRange
            }

        })
    }
}