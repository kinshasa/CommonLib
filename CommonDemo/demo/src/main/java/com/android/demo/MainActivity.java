package com.android.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.base.activity.BaseActivity;
import com.android.base.ui.RoofLayout;

public class MainActivity extends BaseActivity {
    private RoofLayout roofLayout;
    private Context context = MainActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        roofLayout = new RoofLayout(context);
        setContentView(roofLayout);
    }
}
