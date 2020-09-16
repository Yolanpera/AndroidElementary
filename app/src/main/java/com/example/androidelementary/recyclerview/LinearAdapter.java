package com.example.androidelementary.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidelementary.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private LinearRecyclerViewActivity.OnItemClickListener mListener;

    public LinearAdapter(Context context, LinearRecyclerViewActivity.OnItemClickListener mListener){
        this.mContext = context;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.textView.setText("Hello");
        holder.itemView.setOnClickListener(v -> {
            mListener.onClick(position);
        });
        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(mContext, "LongClick    " + position, Toast.LENGTH_SHORT).show();
            return true;
        });
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
}
