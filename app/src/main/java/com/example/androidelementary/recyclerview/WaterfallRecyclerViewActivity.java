package com.example.androidelementary.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidelementary.R;

import java.util.ArrayList;

public class WaterfallRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvWaterfall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_waterfall_recycler_view);
        mRvWaterfall = findViewById(R.id.rv_waterfall);
        mRvWaterfall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd6);
        list.add(R.mipmap.staggerd3);
        list.add(R.mipmap.staggerd4);
        list.add(R.mipmap.staggerd5);
        list.add(R.mipmap.staggerd2);
        list.add(R.mipmap.staggerd7);
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd6);
        list.add(R.mipmap.staggerd3);
        list.add(R.mipmap.staggerd4);
        list.add(R.mipmap.staggerd5);
        list.add(R.mipmap.staggerd2);
        list.add(R.mipmap.staggerd7);
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd6);
        list.add(R.mipmap.staggerd3);
        list.add(R.mipmap.staggerd4);
        list.add(R.mipmap.staggerd5);
        list.add(R.mipmap.staggerd2);
        list.add(R.mipmap.staggerd7);
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd6);
        list.add(R.mipmap.staggerd3);
        list.add(R.mipmap.staggerd4);
        list.add(R.mipmap.staggerd5);
        list.add(R.mipmap.staggerd2);
        list.add(R.mipmap.staggerd7);
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd6);
        list.add(R.mipmap.staggerd3);
        list.add(R.mipmap.staggerd4);
        list.add(R.mipmap.staggerd1);
        list.add(R.mipmap.staggerd2);
        list.add(R.mipmap.staggerd7);
        mRvWaterfall.addItemDecoration(new MyDecoration());
        mRvWaterfall.setAdapter(new StaggeredGridAdapter(WaterfallRecyclerViewActivity.this, list, (LinearRecyclerViewActivity.OnItemClickListener) pos -> {
            Toast.makeText(WaterfallRecyclerViewActivity.this, "Click   " + pos, Toast.LENGTH_SHORT).show();
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.recycler_divider2);
            outRect.set(gap, gap, gap, gap);
        }
    }

    interface OnItemClickListener{
        void onClick(int pos);
    }
}