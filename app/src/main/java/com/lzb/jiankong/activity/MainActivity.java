package com.lzb.jiankong.activity;


import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lzb.jiankong.R;
import com.lzb.jiankong.adapter.app.RunAppAdapter;
import com.lzb.jiankong.application.MyApplication;
import com.lzb.jiankong.bean.RunAppBean;
import com.lzb.jiankong.databinding.ActivityMainBinding;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private RunAppAdapter runAppAdapter;

    List<RunAppBean> list = new ArrayList<>();
    private IWXAPI api;


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
        boolean falg = PermissionUtils.isGranted(Manifest.permission.USE_FULL_SCREEN_INTENT);
        Set<String> set = ProcessUtils.getAllBackgroundProcesses();
        ToastUtils.showLong(falg + "-");
        list.forEach(r -> {
            RunAppBean runAppBean = new RunAppBean();
            runAppBean.setName(r.processName);
            this.list.add(runAppBean);
        });
        StringBuffer sb = new StringBuffer();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            sb.append(PhoneUtils.getIMEI());
        }
        sb.append("getIMSI-->" + PhoneUtils.getIMSI());
        sb.append("getSerial-->" + PhoneUtils.getSerial());
        sb.append("getDeviceId-->" + PhoneUtils.getDeviceId());
        sb.append(CollectionUtils.newArrayList(
                ("isPhone" + PhoneUtils.isPhone()),
                ("getDeviceId" + PhoneUtils.getDeviceId()),
                ("getSerial" + PhoneUtils.getSerial()),
                ("getIMEI" + PhoneUtils.getIMEI()),
                ("getMEID" + PhoneUtils.getMEID()),
                ("getIMSI" + PhoneUtils.getIMSI()),
                ("getPhoneType" + PhoneUtils.getPhoneType()),
                ("isSimCardReady" + PhoneUtils.isSimCardReady()),
                ("getSimOperatorName" + PhoneUtils.getSimOperatorName()),
                ("getSimOperatorByMnc" + PhoneUtils.getSimOperatorByMnc())
        ).toString());
        sb.append(set.toString());
        mBinding.mainTv.setText(sb.toString());
        api = WXAPIFactory.createWXAPI(this, MyApplication.APP_ID, false);

        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(runAppAdapter);
        runAppAdapter.addAll(this.list);
        runAppAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this, WallpaperActivity.class);
        mBinding.btn.setOnClickListener(v -> {
//            startActivity(intent);
            api.registerApp(MyApplication.APP_ID);
            final SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            api.sendReq(req);


        });
    }
}
