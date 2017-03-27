package com.android.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.base.ui.RoofLayout;

/**
 * Created by lshaobocsu@gmail.com on 2017.3.27.
 *
 * 继承API相关Activity，处理首次加载页面的Activity
 */

public class LoadingActivity  extends BaseActivity{

    private RoofLayout roofLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        roofLayout = new RoofLayout(this);
        setContentView(roofLayout);
    }
}
