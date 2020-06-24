package com.lzb.jiankong.activity;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.lzb.jiankong.R;
import com.lzb.jiankong.adapter.RunAppAdapter;
import com.lzb.jiankong.bean.RunAppBean;
import com.lzb.jiankong.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private RunAppAdapter runAppAdapter;

      List<RunAppBean> list = new ArrayList<>();

    @Override
    int initView() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    void init() {
        runAppAdapter = new RunAppAdapter(R.layout.item_main);

        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        list.forEach(r -> {
            RunAppBean runAppBean = new RunAppBean();
            runAppBean.setName(r.processName);
            this.list.add(runAppBean);
        });


    }
}
