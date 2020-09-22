package com.example.androidelementary.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidelementary.R;

public class BeforeJumpActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_jump);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeforeJumpActivity.this, AfterJumpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_bottom, 0);
            }
        });
    }
}