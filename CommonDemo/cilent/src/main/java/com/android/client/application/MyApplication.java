package com.android.client.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by liushaobo.xicp.net on 2016/6/14.
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;

        //初始化图片加载器
        Fresco.initialize(this);
    }


    public  static MyApplication getInstance(){
        return instance;
    }
}
