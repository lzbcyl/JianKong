package com.lzb.jiankong.adapter.app;

import com.lzb.jiankong.bean.RunAppBean;
import com.lzb.jiankong.databinding.ItemMainBinding;
import com.lzb.lzbutils.adapter.base.BaseBindingAdapter;
import com.lzb.lzbutils.adapter.base.BaseBindingHolder;

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
