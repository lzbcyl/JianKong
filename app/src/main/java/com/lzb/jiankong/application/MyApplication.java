package com.lzb.jiankong.application;

import android.app.Application;
import android.content.Context;

import com.lzb.lzbutils.http.HttpUtils;

public class MyApplication extends Application {
    public static final String APP_ID = "wx19729e342e917d2f";
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        HttpUtils.getInstance().init(this);

    }

}
