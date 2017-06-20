package com.android.client;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by liushaobo.xicp.net on 2016/6/14.
 */
public class MainApplication extends Application {

    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;

        //初始化图片加载器
        Fresco.initialize(this);

        // you must install multiDex whatever tinker is installed!
//        MultiDex.install(this);
//
//
//        // 安装tinker
//        Beta.installTinker();
    }


    public  static MainApplication getInstance(){
        return instance;
    }
}
