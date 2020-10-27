package com.example.androidelementary.Handler.handlerThread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

public class HandlerThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Looper.prepare();
            new Handler(Looper.myLooper()){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    //处理消息
                }
            };
            Looper.loop();
        }).start();


        HandlerThread handlerThread = new HandlerThread("ThreadWithLooper");
        handlerThread.start();
        new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                ////处理消息
            }
        };

    }
}
