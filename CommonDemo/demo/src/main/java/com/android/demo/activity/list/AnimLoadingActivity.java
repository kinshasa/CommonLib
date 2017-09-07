package com.android.demo.activity.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.base.activity.BaseActivity;
import com.android.demo.R;

/**
 * Created by lshaobocsu@gmail.com on 2017.3.27.
 */

public class AnimLoadingActivity extends BaseActivity {


    private Button mBtnNormal;
    private AlertDialog mAdNormal;
    private EditText mEtNormal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // requestFeature() must be called before adding content
        requestWindowFeature(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        setContentView(R.layout.activity_anim_loading);
        mBtnNormal = (Button)findViewById(R.id.btn_normal);
        mEtNormal = new EditText(this);
        mEtNormal.setText("测试");
        mBtnNormal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mAdNormal == null){
                   mAdNormal = new AlertDialog.Builder(AnimLoadingActivity.this)
                           .setTitle("请输入")
                           .setIcon(android.R.drawable.ic_dialog_info)
                           .setView(new EditText(AnimLoadingActivity.this))
                           .setPositiveButton("确定", null)
                           .setNegativeButton("取消", null)
                           .show();
               }
               if(mAdNormal.isShowing()){
                   mAdNormal.dismiss();
               }else{
                   mAdNormal.show();
               }
           }
       });
    }
}
