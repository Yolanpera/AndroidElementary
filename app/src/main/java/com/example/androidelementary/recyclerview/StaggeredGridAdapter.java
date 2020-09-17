package com.example.androidelementary.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidelementary.R;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private LinearRecyclerViewActivity.OnItemClickListener mListener;
    private List list;


    public StaggeredGridAdapter(Context context, List list, LinearRecyclerViewActivity.OnItemClickListener mListener){
        this.mContext = context;
        this.mListener = mListener;
        this.list = list;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggerd_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.imageView.setImageResource((Integer) list.get(position));
        holder.itemView.setOnClickListener(v -> {
            mListener.onClick(position);
        });
        //直接给holder设置点击事件
        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(mContext, "LongClick    " + position, Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }


}
