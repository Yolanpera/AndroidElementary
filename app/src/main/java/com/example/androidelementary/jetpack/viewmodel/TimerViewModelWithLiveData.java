package com.example.androidelementary.jetpack.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModelWithLiveData extends ViewModel {

    private MutableLiveData<Integer> second;
    private Timer timer;


    public LiveData<Integer> getSecond() {
        if (second == null) {
            second = new MutableLiveData<>();
        }
        return second;
    }

    public void timing() {
        if (timer == null) {
            Timer timer = new Timer();
            second.setValue(0);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    second.postValue(second.getValue() + 1);
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

}
