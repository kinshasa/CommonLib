package net.xicp.liushaobo.comlib.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import net.xicp.liushaobo.comlib.R;
import net.xicp.liushaobo.comlib.utils.log.L;


/**
 * Created by liusp@gagc.com.cn on 2016/6/24.
 */
@SuppressWarnings("unused")
public class BaseViewActivity extends LogActivity {


    protected Context context = BaseViewActivity.this;

    /**
     * 主页面 - 顶部栏 BaseViewGroupTop
     */
    protected ViewGroup bvg_top;
    protected ViewGroup bvg_top_left;
    protected ViewGroup bvg_top_center;
    protected ViewGroup bvg_top_right;

    protected TextView tvTopTitle;

    /**
     * 主页面 - 中部 BaseViewGroupBody
     */
    protected ViewGroup bvg_body;

    /**
     * 主页面 - 底部栏 BaseViewGroupBottom
     */
    protected ViewGroup bvg_bottom;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.activity_base_view);

        initBaseView();
    }

    private final boolean initBaseView() {
        L.v();
        try {
            bvg_top = (ViewGroup) findViewById(R.id.bvg_top);
            bvg_body = (ViewGroup) findViewById(R.id.bvg_body);
            bvg_bottom = (ViewGroup) findViewById(R.id.bvg_bottom);
            bvg_top_left = (ViewGroup) bvg_top.findViewById(R.id.bvg_top_left);
            bvg_top_center = (ViewGroup) bvg_top.findViewById(R.id.bvg_top_center);
            bvg_top_right = (ViewGroup) bvg_top.findViewById(R.id.bvg_top_right);

            tvTopTitle = (TextView) bvg_top_center.findViewById(R.id.tv_top_title);

            /**是否隐藏底部栏**/
            bvg_bottom.setVisibility(View.GONE);

        } catch (Exception e) {
            L.e(e);
            return false;
        } finally {

        }
        return true;
    }


    /**
     * 默认隐藏底部栏
     *
     * @return 是否隐藏
     */
    protected void setBvgBottomVisible(boolean show) {
        if (show) {
            bvg_bottom.setVisibility(View.VISIBLE);
        } else {
            bvg_bottom.setVisibility(View.GONE);
        }
    }

    /**
     * 设置顶部栏View
     *
     * @param resid
     * @return
     */
    protected final boolean setBaseTopView(int resid) {
        //if (vid == 0) return false;

        View view = getLayoutInflater().inflate(resid, null);
        return setBaseTopView(view);
    }

    protected final boolean setBaseTopView(View view) {

        if (bvg_top != null && view != null) {
            bvg_top.removeAllViews();
            bvg_top.addView(view);
            return true;
        }
        return false;
    }

    /**
     * 设置中部栏View
     *
     * @param resid
     * @return
     */
    public void setContentView(int resid) {
        //if (vid == 0) return false;

        View view = getLayoutInflater().inflate(resid, null);
        setContentView(view);
    }

    protected ViewGroup getContentView() {
        return bvg_body;
    }

    @Override
    public void setContentView(View view) {

        if (bvg_body != null && view != null) {
            bvg_body.removeAllViews();
            bvg_body.addView(view);
        }
    }

    /**
     * 设置底部栏View
     *
     * @param resid
     * @return
     */
    protected final boolean setBaseBottomView(int resid) {
        //if (vid == 0) return false;

        View view = getLayoutInflater().inflate(resid, null);
        return setBaseBottomView(view);
    }

    protected final boolean setBaseBottomView(View view) {

        if (bvg_bottom != null && view != null) {
            bvg_bottom.removeAllViews();
            bvg_bottom.addView(view);
            return true;
        }
        return false;
    }


    /**
     * 设置顶部栏-中间文字
     *
     * @param resid
     */
    protected void setBaseTopLabel(int resid) {
        tvTopTitle.setText(resid);
    }

    protected void setBaseTopLabel(String str) {
        tvTopTitle.setText(str);
    }


    /**
     * 隐藏键盘
     */
    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            View localView = getCurrentFocus();
            if (localView != null && localView.getWindowToken() != null) {
                IBinder windowToken = localView.getWindowToken();
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        }
    }

}
