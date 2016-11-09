package com.android.rn;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;

import java.util.List;

/**
 * Created by liusp@gagc.com.cn on 2016.11.9.
 */

public class MainActivity extends ReactActivity {

    @Override
    protected String getMainComponentName() {
        return "dscf";
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
