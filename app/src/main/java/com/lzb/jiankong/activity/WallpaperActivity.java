package com.lzb.jiankong.activity;

import androidx.recyclerview.widget.GridLayoutManager;

import com.lzb.jiankong.R;
import com.lzb.jiankong.adapter.app.WapperHeaderAdapter;
import com.lzb.jiankong.bean.WapperItemBean;
import com.lzb.jiankong.databinding.ActivityWallpaperBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 壁纸
 */
public class WallpaperActivity extends BaseActivity<ActivityWallpaperBinding> {
    @Override
    int initView() {
        return R.layout.activity_wallpaper;
    }

    @Override
    void init() {
        mBinding.headerRvId.setLayoutManager(new GridLayoutManager(this, 3));
        WapperHeaderAdapter adapter = new WapperHeaderAdapter(R.layout.item_wapper_header);
        List<WapperItemBean> list =new ArrayList<>();
        WapperItemBean wapperItemBean=new WapperItemBean();
        wapperItemBean.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604495326543&di=66825982d0e77b335bba11617f187bd0&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F56%2F12%2F01300000164151121576126282411.jpg");
        list.add(wapperItemBean);
        list.add(wapperItemBean);
        list.add(wapperItemBean);
        adapter.setNewData(list);
        mBinding.headerRvId.setAdapter(adapter);
    }
}
