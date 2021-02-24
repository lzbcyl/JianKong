package com.lzb.jiankong.activity.image;

import com.lzb.jiankong.R;
import com.lzb.jiankong.activity.BaseActivity;
import com.lzb.jiankong.bean.rep.WallpaperBean;
import com.lzb.jiankong.databinding.ActivityImageviewBindingImpl;
import com.lzb.jiankong.utils.LogUtils;
import com.lzb.jiankong.viewmodel.image.ImageViewViewModel;
import com.lzb.lzbutils.base.BaseLoadActivity;
import com.lzb.lzbutils.rxbus.RxBus;

import io.reactivex.disposables.Disposable;

public class ImageViewActivity extends BaseLoadActivity<ImageViewViewModel, ActivityImageviewBindingImpl> {
    @Override
    public int initView() {
        return R.layout.activity_imageview;
    }

    @Override
    public void init() {
        Disposable subscribe = RxBus.getDefault().toObservable(WallpaperBean.class).subscribe(w -> {
            LogUtils.loge("Tag", w);
//            mBinding.setData(w);
        }, e -> {
            LogUtils.loge("Tag", e);
        });
        showContentView();

        String URL=getIntent().getStringExtra("URL");
        WallpaperBean wallpaperBean=new WallpaperBean();
        wallpaperBean.setImageUrl(URL);
        mBinding.setData(wallpaperBean);
        addSubscription(subscribe);
    }


}
