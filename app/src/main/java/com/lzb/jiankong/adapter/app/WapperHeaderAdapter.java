package com.lzb.jiankong.adapter.app;

import com.lzb.jiankong.bean.rep.WallpaperBean;
import com.lzb.jiankong.databinding.ItemWapperHeaderBinding;
import com.lzb.lzbutils.adapter.base.BaseBindingAdapter;
import com.lzb.lzbutils.adapter.base.BaseBindingHolder;

public class WapperHeaderAdapter extends BaseBindingAdapter<WallpaperBean, ItemWapperHeaderBinding> {
    public WapperHeaderAdapter(int layoutId) {
        super(layoutId);
    }

    @Override
    protected void bindView(BaseBindingHolder holder, WallpaperBean bean, ItemWapperHeaderBinding binding, int position) {
        binding.setItem(bean);
        binding.executePendingBindings();
    }
}
