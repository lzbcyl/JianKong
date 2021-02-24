package com.lzb.jiankong.activity.wallpaper;

import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lzb.jiankong.R;
import com.lzb.jiankong.activity.BaseActivity;
import com.lzb.jiankong.activity.image.ImageViewActivity;
import com.lzb.jiankong.adapter.app.WapperHeaderAdapter;
import com.lzb.jiankong.api.HttpBaseApi;
import com.lzb.jiankong.bean.rep.WallpaperBean;
import com.lzb.jiankong.databinding.ActivityWallpaperBinding;
import com.lzb.jiankong.utils.Meizi;
import com.lzb.lzbutils.http.HttpUtils;
import com.lzb.lzbutils.rxbus.RxBus;
import com.lzb.lzbutils.utils.LogUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 壁纸
 */
public class WallpaperActivity extends BaseActivity<ActivityWallpaperBinding> {
    @Override
    public int initView() {
        return R.layout.activity_wallpaper;
    }

    WapperHeaderAdapter adapter = new WapperHeaderAdapter(R.layout.item_wapper_header);
    static int page = 1;
    int size = 20;

    @Override
    public void init() {
        getMeiziUrl();
        mBinding.headerRvId.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.headerRvId.setRefreshEnabled(true);
        mBinding.headerRvId.setLoadMoreEnabled(true);

        mBinding.headerRvId.setAdapter(adapter);
        load();

    }

    private void getMeiziUrl() {
        try {
            List<WallpaperBean> list = new ArrayList<>();
            InputStream is = getResources().getAssets().open("f1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            int i = 0;
            while ((str = br.readLine()) != null) {
//                i++;
//                if(i<(page-1)*size){
//                    continue;
//                }
//                if (i > (page+1) * size) {
//                    break;
//                }
//
                if (StringUtils.isEmpty(str)) {
                    continue;
                }

                WallpaperBean wb = new WallpaperBean();
                wb.setImageUrl(str.split(", ")[0]);
                list.add(wb);
            }
            adapter.addAll(list);
            adapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {

        getMeiziUrl();
//        adapter.addAll(list);
//        adapter.notifyDataSetChanged();
//        HttpUtils.subscribe(HttpBaseApi.getFrontApi().findList(), s -> {
//            if (null != s.getData()) {
//                adapter.addAll(s.getData());
//                adapter.notifyDataSetChanged();
//            }
//        }, e -> {
//            LogUtils.loge("TAG", e.getMessage());
//        });
        mBinding.headerRvId.setOnLoadMoreListener(() -> {
            page++;
            getMeiziUrl();

        });
        mBinding.headerRvId.setOnItemClickListener((v, p) -> {
            LogUtils.loge("TAG", adapter.getData().get(p) + "" + p);
            WallpaperBean wallpaperBean = adapter.getData().get(p);
            Intent i = new Intent(this, ImageViewActivity.class);
            i.putExtra("URL", wallpaperBean.getImageUrl());
            startActivity(i);
            RxBus.getDefault().send(wallpaperBean);
        });
    }
}
