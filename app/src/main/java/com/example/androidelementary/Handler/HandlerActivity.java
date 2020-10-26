package com.example.androidelementary.Handler;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.androidelementary.R;

/**
 * 两种发送 Message 的区别在于一个是指定 Message.what 一个是指定 Messgae.callback
 * 最终都是调用 sendMessageAtTime() 发送事件
 */
public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        TextView textView = findViewById(R.id.text);
        //sendMessage
        mHandler = new Handler() {
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    textView.setText("修改后的文字");
                }
            }
        };
        new Thread(()-> {
            try {
                Thread.sleep(5000);
                mHandler.sendEmptyMessage(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // postMessge
        mHandler = new Handler();
        new Thread(()-> {
            try {
                Thread.sleep(5000);
                mHandler.post(() -> textView.setText("修改后的文字"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}