package com.android.client.Fragment.user;

import android.content.Intent;

import com.android.client.webview.WebActivity;
import com.android.lib.fragment.LoadingFragment;

/**
 * Created by liushaobo.xicp.net on 2016/6/6.
 */
public class UserFragment extends LoadingFragment {


    @Override
    protected void initHeadView() {

    }

    @Override
    protected void initBodyView() {

    }

    @Override
    protected void initUIWidget() {

    }

    @Override
    protected void initLogic() {
        startActivity(new Intent().setClass(getActivity(), WebActivity.class));
    }

    @Override
    protected void setUI() {

    }

    @Override
    protected boolean isDataNotLoad() {
        return false;
    }
}
