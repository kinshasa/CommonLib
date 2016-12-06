package com.android.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.android.base.activity.R;

/**
 * Created by liusp@gagc.com.cn on 2016.12.6.
 */

public class RoofLayout extends InitLayout {

    public RoofLayout(Context context) {
        super(context);
    }

    @Override
    protected View createView(Context context, AttributeSet attrs) {
        View container = LayoutInflater.from(context).inflate(R.layout.layout_roof, null);
        return container;
    }
}
