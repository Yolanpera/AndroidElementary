package com.example.androidelementary.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.androidelementary.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LinearRecyclerViewActivity.class);
            startActivity(intent);
        });
    }
}