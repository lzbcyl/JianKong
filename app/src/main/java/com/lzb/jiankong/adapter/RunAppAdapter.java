package com.lzb.jiankong.adapter;

import com.lzb.jiankong.adapter.base.BaseBindingAdapter;
import com.lzb.jiankong.adapter.base.BaseBindingHolder;
import com.lzb.jiankong.bean.RunAppBean;
import com.lzb.jiankong.databinding.ItemMainBinding;

public class RunAppAdapter extends BaseBindingAdapter<RunAppBean, ItemMainBinding> {
    public RunAppAdapter(int layoutId) {
        super(layoutId);
    }


    @Override
    protected void bindView(BaseBindingHolder holder, RunAppBean bean, ItemMainBinding binding, int position) {
        binding.setBean(bean);
        binding.executePendingBindings();
    }
}
