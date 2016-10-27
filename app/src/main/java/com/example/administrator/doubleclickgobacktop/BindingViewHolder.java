package com.example.administrator.doubleclickgobacktop;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T mBinding;
    public BindingViewHolder(T bingding) {
        super(bingding.getRoot());
        mBinding = bingding;
    }

    public T getmBinding(){
        return mBinding;
    }
}
