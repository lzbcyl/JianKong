package com.lzb.jiankong.adapter.app;

import com.lzb.jiankong.adapter.base.BaseBindingAdapter;
import com.lzb.jiankong.adapter.base.BaseBindingHolder;
import com.lzb.jiankong.bean.WapperItemBean;
import com.lzb.jiankong.databinding.ItemWapperHeaderBinding;

public class WapperHeaderAdapter extends BaseBindingAdapter<WapperItemBean, ItemWapperHeaderBinding> {
    public WapperHeaderAdapter(int layoutId) {
        super(layoutId);
    }

    @Override
    protected void bindView(BaseBindingHolder holder, WapperItemBean bean, ItemWapperHeaderBinding binding, int position) {
        binding.setItem(bean);
        binding.executePendingBindings();
    }
}
