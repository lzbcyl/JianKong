package com.lzb.jiankong.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    private T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(this), initView(), null, false);
        setContentView(mBinding.getRoot());
        init();
    }

    /**
     * 初始化页面
     *
     * @return
     */
    abstract int initView();

    /**
     * 初始化数据
     */

    abstract void init();


}
