package com.android.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.base.ui.RoofLayout;

/**
 * Created by liusp@gagc.com.cn on 2016.10.25.
 */

public class BaseActivity extends LifeCycleActivity {

    private RoofLayout roofLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        roofLayout = new RoofLayout(this);
        setContentView(roofLayout);
    }
}
