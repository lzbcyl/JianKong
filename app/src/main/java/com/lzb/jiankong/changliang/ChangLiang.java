package com.lzb.jiankong.changliang;

import androidx.databinding.library.baseAdapters.BuildConfig;

import com.lzb.jiankong.application.MyApplication;
import com.lzb.jiankong.utils.AppUtils;

import java.util.HashMap;

public class ChangLiang {
    private static Boolean isDubug = BuildConfig.DEBUG;
    /**
     * 测试环境配置
     */
    public static HashMap<String, String> map_dug = new HashMap() {{
        put("FRONTURL", "http://192.168.8.148:9002");
    }};
    /**
     * 正式环境配置
     */
    public static HashMap<String, String> map_replase = new HashMap() {{
        put("FRONTURL", "http://192.168.8.148:9002");
    }};

    /**
     * FrontUrl
     */
    public static String FrontUrl = isDubug ? map_dug.get("FRONTURL") : map_replase.get("FRONTURL");

}
