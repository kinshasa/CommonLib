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
    private Context context = BaseActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //roofLayout = new RoofLayout(context);
        //setContentView(roofLayout);
    }
}
