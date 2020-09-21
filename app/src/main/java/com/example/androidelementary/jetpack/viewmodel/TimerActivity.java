package com.example.androidelementary.jetpack.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidelementary.R;

public class TimerActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        init();
    }

    private void init(){
        textView = findViewById(R.id.text);
        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        timerViewModel.setOnTimeChangeListener(second -> runOnUiThread(() -> textView.setText("TIME:" + second)));
        timerViewModel.timing();
    }
}