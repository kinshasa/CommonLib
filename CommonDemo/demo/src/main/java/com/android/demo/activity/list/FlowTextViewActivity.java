package com.android.demo.activity.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;

import com.android.base.activity.BaseActivity;
import com.android.demo.R;

import uk.co.deanwild.flowtextview.FlowTextView;

/**
 * Created by lshaobocsu@gmail.com on 2017.3.27.
 */

public class FlowTextViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flow_textview);
        FlowTextView flowTextView = (FlowTextView) findViewById(R.id.ftv);
        String content = getString(R.string.lorem);
        Spanned html = Html.fromHtml(content);
        flowTextView.setText(html);
    }
}
