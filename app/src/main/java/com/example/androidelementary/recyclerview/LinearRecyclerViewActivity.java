package com.example.androidelementary.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidelementary.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRvmain = findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(this));
        mRvmain.addItemDecoration(new MyDecoration());
        mRvmain.setAdapter(new LinearAdapter(this, new OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "Click   " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0, getResources().getDimensionPixelOffset(R.dimen.recycler_divider));
        }
    }

    interface OnItemClickListener{
        void onClick(int pos);
    }
}