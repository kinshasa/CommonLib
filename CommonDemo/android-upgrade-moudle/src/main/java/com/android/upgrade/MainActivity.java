package com.android.upgrade;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.bugly.Bugly;

/**
 * Created by liusp@gagc.com.cn on 2016.11.9.
 */

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bugly自动升级初始化
        Bugly.init(getApplicationContext(), "f68be3afe7", false);
    }
}
