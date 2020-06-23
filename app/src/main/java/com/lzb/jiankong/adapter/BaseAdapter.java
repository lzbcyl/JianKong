package com.lzb.jiankong.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class BaseAdapter<T extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private T mBinding;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
