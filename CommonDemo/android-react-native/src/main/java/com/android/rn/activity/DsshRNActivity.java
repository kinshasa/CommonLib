package com.android.rn.activity;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;

import java.util.List;

/**
 * Created by liusp@gagc.com.cn on 2016.11.9.
 */

public class DsshRNActivity extends ReactActivity {
    @Override
    protected String getMainComponentName() {
        return "dssh";
    }

    @Override
    protected boolean getUseDeveloperSupport() {
        return false;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return null;
    }
}
