package com.lzb.jiankong.api;

import com.lzb.jiankong.bean.rep.WallpaperBean;
import com.lzb.lzbutils.bean.BaseResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FrontApi {
    /**
     * 图片墙列表
     *
     * @return
     */
    @GET("/front/wallper/findList")
    Observable<BaseResult<List<WallpaperBean>>> findList();
}
