package com.example.androidelementary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class RTLActivity extends AppCompatActivity {

    private View parentView;
    private Button changeBtn;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_t_l);
        parentView = findViewById(R.id.parentView);
        changeBtn = findViewById(R.id.change_btn);
        changeBtn.setOnClickListener((v)->{
            parentView.setBackgroundColor(Color.TRANSPARENT);
        });
    }

}