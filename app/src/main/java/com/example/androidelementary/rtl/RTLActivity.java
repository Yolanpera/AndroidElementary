package com.example.androidelementary.rtl;

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
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidelementary.R;

public class RTLActivity extends AppCompatActivity {

    private View parentView;
    private Button changeBtn;
    private ViewGroup micRoombanner;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_t_l);
        parentView = findViewById(R.id.parentView);
        changeBtn = findViewById(R.id.change_btn);
        micRoombanner = findViewById(R.id.mic_room_banner);
        changeBtn.setOnClickListener((v)->{
            parentView.setBackgroundColor(Color.TRANSPARENT);
        });
        changeBtn.setOnLongClickListener(v -> {
            v.setVisibility(View.GONE);
            return true;
        });
    }

}