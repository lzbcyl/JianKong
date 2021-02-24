package com.lzb.jiankong.api;

import com.lzb.jiankong.changliang.ChangLiang;
import com.lzb.lzbutils.http.HttpUtils;

public class HttpBaseApi {
    /**
     * 获取前置API
     *
     * @return
     */
    public static FrontApi getFrontApi() {
        return HttpUtils.create(FrontApi.class, ChangLiang.FrontUrl);
    }
}
