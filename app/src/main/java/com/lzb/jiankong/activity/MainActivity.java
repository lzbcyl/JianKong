package com.lzb.jiankong.activity;


import android.app.ActivityManager;
import android.content.Context;

import com.lzb.jiankong.R;

public class MainActivity extends BaseActivity {


    @Override
    int initView() {
        return R.layout.activity_main;
    }

    @Override
    void init() {
        ActivityManager activityManager= (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getRunningAppProcesses();
    }
}
