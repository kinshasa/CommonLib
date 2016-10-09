package com.android.upgrade;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by liusp@gagc.com.cn on 2016.10.9.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "注册时申请的APPID", false);
    }
}
