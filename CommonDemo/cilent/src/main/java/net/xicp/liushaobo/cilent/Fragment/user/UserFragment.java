package net.xicp.liushaobo.cilent.Fragment.user;

import android.content.Intent;

import net.xicp.liushaobo.comlib.fragment.LoadingFragment;
import net.xicp.liushaobo.cilent.webview.WebActivity;

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