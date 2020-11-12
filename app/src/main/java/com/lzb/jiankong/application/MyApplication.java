package com.lzb.jiankong.application;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class MyApplication  extends Application {
    public static final String APP_ID = "wx19729e342e917d2f";

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
