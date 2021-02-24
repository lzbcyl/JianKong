package com.lzb.jiankong.activity;


import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lzb.jiankong.R;
import com.lzb.jiankong.activity.wallpaper.WallpaperActivity;
import com.lzb.jiankong.adapter.app.RunAppAdapter;
import com.lzb.jiankong.application.MyApplication;
import com.lzb.jiankong.bean.RunAppBean;
import com.lzb.jiankong.databinding.ActivityMainBinding;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private RunAppAdapter runAppAdapter;

    List<RunAppBean> list = new ArrayList<>();
    private IWXAPI api;


    @Override
    public int initView() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void init() {
        runAppAdapter = new RunAppAdapter(R.layout.item_main);

        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        boolean falg = PermissionUtils.isGranted(Manifest.permission.USE_FULL_SCREEN_INTENT);
        ToastUtils.showLong(falg + "-");
        list.forEach(r -> {
            RunAppBean runAppBean = new RunAppBean();
            runAppBean.setName(r.processName);
            this.list.add(runAppBean);
        });
        StringBuffer sb = new StringBuffer();

        mBinding.mainTv.setText(sb.toString());
        api = WXAPIFactory.createWXAPI(this, MyApplication.APP_ID, false);

        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(runAppAdapter);
        runAppAdapter.addAll(this.list);
        runAppAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this, WallpaperActivity.class);

        mBinding.btn.setOnClickListener(v -> {
            startActivity(intent);
//            api.registerApp(MyApplication.APP_ID);
//            final SendAuth.Req req = new SendAuth.Req();
//            req.scope = "snsapi_userinfo";
//            req.state = "wechat_sdk_demo_test";
//            api.sendReq(req);


        });
    }
}
