package com.example.androidelementary.jetpack.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidelementary.R;

public class TimerWithLiveDataActivity extends AppCompatActivity {

    TimerViewModelWithLiveData timerViewModelWithLiveData;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_with_live_data);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.btn);
        init();
    }

    private void init(){
        timerViewModelWithLiveData = new ViewModelProvider(this).get(TimerViewModelWithLiveData.class);
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) timerViewModelWithLiveData.getSecond();

        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer second) {
                textView.setText("Time:" + second);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveData.setValue(0);
            }
        });

        timerViewModelWithLiveData.timing();
    }
}