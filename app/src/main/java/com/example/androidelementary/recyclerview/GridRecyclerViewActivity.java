package com.example.androidelementary.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidelementary.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        GridAdapter gridAdapter = new GridAdapter(this, pos -> Toast.makeText(GridRecyclerViewActivity.this, "Click   " + pos, Toast.LENGTH_SHORT).show());
        mRvGrid.setAdapter(gridAdapter);
    }

    interface OnItemClickListener{
        void onClick(int pos);
    }
}

