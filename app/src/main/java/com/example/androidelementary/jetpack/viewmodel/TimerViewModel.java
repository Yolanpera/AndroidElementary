package com.example.androidelementary.jetpack.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {

    private String TAG = getClass().getCanonicalName();
    private Timer timer;
    private int second;
    private OnTimeChangeListener onTimeChangeListener;

    public void timing() {
        if (timer == null) {
            Timer timer = new Timer();
            second = 0;
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    second ++;
                    if (onTimeChangeListener != null) {
                        onTimeChangeListener.onTimeChanged(second);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared()");
        timer.cancel();
    }

    interface OnTimeChangeListener{
        void onTimeChanged(int second);
    }

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.onTimeChangeListener = onTimeChangeListener;
    }
}
