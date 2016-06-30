package net.xicp.liushaobo.comlib.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by liusp@gagc.com.cn on 2016/6/29.
 */
public class QuickFragment extends BaseFragment {

    protected Context context;
    protected View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
