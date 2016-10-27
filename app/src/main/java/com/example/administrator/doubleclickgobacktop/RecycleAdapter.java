package com.example.administrator.doubleclickgobacktop;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.administrator.doubleclickgobacktop.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class RecycleAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private List<ItemBean> dataList = new ArrayList<>();
    private Context mContext;

    public RecycleAdapter(Context context,List<ItemBean> list) {
        super();
        mContext = context;
        dataList = list;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.layout_item,parent,false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        ItemBean bean = dataList.get(position);
        holder.getmBinding().setVariable(BR.item,bean);
        holder.getmBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
