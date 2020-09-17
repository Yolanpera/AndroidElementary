package com.example.androidelementary.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.androidelementary.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear, mBtnHorizon, mBtnGrid, mBtnWaterfall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnLinear.setOnClickListener(v -> {
            Intent intent = new Intent(this, LinearRecyclerViewActivity.class);
            startActivity(intent);
        });
        mBtnHorizon = findViewById(R.id.btn_horizon);
        mBtnHorizon.setOnClickListener(v -> {
            Intent intent = new Intent(this, HorRecyclerViewActivity.class);
            startActivity(intent);
        });
        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnGrid.setOnClickListener(v -> {
            Intent intent = new Intent(this, GridRecyclerViewActivity.class);
            startActivity(intent);
        });
        mBtnWaterfall = findViewById(R.id.btn_waterfall);
        mBtnWaterfall.setOnClickListener(v -> {
            Intent intent = new Intent(this, WaterfallRecyclerViewActivity.class);
            startActivity(intent);
        });
    }
}