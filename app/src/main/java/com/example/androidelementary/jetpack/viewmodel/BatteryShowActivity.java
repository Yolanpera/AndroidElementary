package com.example.androidelementary.jetpack.viewmodel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidelementary.R;

public class BatteryShowActivity extends AppCompatActivity {

    private TextView tvBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_show);
        tvBattery = findViewById(R.id.tvBattery);
        BatteryLiveData batteryLiveData = new BatteryLiveData(this);
        batteryLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                tvBattery.setText(integer.toString());
            }
        });
    }
}