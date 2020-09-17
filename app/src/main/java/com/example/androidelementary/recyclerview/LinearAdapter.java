package com.example.androidelementary.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidelementary.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LinearRecyclerViewActivity.OnItemClickListener mListener;

    public LinearAdapter(Context context, LinearRecyclerViewActivity.OnItemClickListener mListener){
        this.mContext = context;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return viewType == 0?
                new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false))
                :new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0){
            ((LinearViewHolder)holder).textView.setText("Hello");
        }else {
            ((LinearViewHolder2)holder).textView.setText("Hi");
        }
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
    public int getItemViewType(int position) {
        return position % 2 == 0? 0: 1;
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
