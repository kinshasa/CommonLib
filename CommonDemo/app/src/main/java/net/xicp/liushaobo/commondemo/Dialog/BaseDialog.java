package net.xicp.liushaobo.commondemo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

/**
 * Created by liushaobo.xicp.net on 2016/5/27.
 */
public  class BaseDialog extends Dialog{

    public BaseDialog(Context context) {
        super(context);

        //去掉系统对话框的title和边框背景
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }
    public BaseDialog(Context context,int theme) {
        super(context,theme);

        //去掉系统对话框的title和边框背景
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }
}
