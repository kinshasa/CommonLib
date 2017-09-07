package com.android.demo.activity.list;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.base.activity.BaseActivity;

/**
 * Created by XP-PC-XXX on 2017/9/7.
 */

public class WifiConnectActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WifiAdmin wifiAdmin = new WifiAdmin(this);
        wifiAdmin.openWifi();
        //创建并连接WIFI
        wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo("testwifi2", "123456789", 3));
        //断开并删除WIFI密码
        //wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo("XP-MOBILE", "111", 3));
    }
}
