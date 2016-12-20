package com.android.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.android.base.activity.InitActivity;
import com.android.base.ui.RoofLayout;

public class MainActivity extends InitActivity {

    protected RoofLayout roofLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        roofLayout = new RoofLayout(this);
        setBaseTopView(roofLayout);

    }
}
