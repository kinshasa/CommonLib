package com.android.demo;

import android.app.Application;

import com.android.demo.service.DataTransferClient;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lshaobocsu@gmail.com on 2017.3.27.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        DataTransferClient.getInstance().connectService(this);
    }
}
