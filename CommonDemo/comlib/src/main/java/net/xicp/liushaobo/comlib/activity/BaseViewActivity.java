package net.xicp.liushaobo.comlib.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.xicp.liushaobo.comlib.R;
import net.xicp.liushaobo.comlib.utils.log.L;


/**
 * Created by liusp@gagc.com.cn on 2016/6/24.
 */
@SuppressWarnings("unused")
public class BaseViewActivity extends BaseActivity {


    protected Context context = BaseViewActivity.this;

    /**
     * 主页面 - 顶部栏 BaseViewGroupTop
     */
    protected ViewGroup vgBaseTop;
    protected ViewGroup vgBaseTopLeft;
    protected ViewGroup vgBaseTopCenter;
    protected ViewGroup vgBaseTopRight;

    /**
     * 主页面 - 顶部栏 - 标题
     */
    protected TextView tvTopTitle;

    /**
     * 主页面 - 中部 BaseViewGroupBody
     */
    protected ViewGroup vgBaseBody;

    /**
     * 主页面 - 底部栏 BaseViewGroupBottom
     */
    protected ViewGroup vgBottom;


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
            vgBaseTop = (ViewGroup) findViewById(R.id.vg_base_top);
            vgBaseBody = (ViewGroup) findViewById(R.id.vg_base_body);
            vgBottom = (ViewGroup) findViewById(R.id.vg_base_bottom);
            vgBaseTopLeft = (ViewGroup) vgBaseTop.findViewById(R.id.vg_base_top_left);
            vgBaseTopCenter = (ViewGroup) vgBaseTop.findViewById(R.id.vg_base_top_center);
            vgBaseTopRight = (ViewGroup) vgBaseTop.findViewById(R.id.vg_base_top_right);

            tvTopTitle = (TextView) vgBaseTopCenter.findViewById(R.id.tv_top_title);

            /**是否隐藏底部栏**/
            vgBottom.setVisibility(View.GONE);

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
            vgBottom.setVisibility(View.VISIBLE);
        } else {
            vgBottom.setVisibility(View.GONE);
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

        if (vgBaseTop != null && view != null) {
            vgBaseTop.removeAllViews();
            vgBaseTop.addView(view);
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
        return vgBaseBody;
    }

    @Override
    public void setContentView(View view) {

        if (vgBaseBody != null && view != null) {
            vgBaseBody.removeAllViews();
            vgBaseBody.addView(view);
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

        if (vgBottom != null && view != null) {
            vgBottom.removeAllViews();
            vgBottom.addView(view);
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
        try {
            tvTopTitle.setText(resid);
        } catch (Exception e) {
            L.e(e);
        }
    }

    protected void setBaseTopLabel(String str) {
        tvTopTitle.setText(str);
    }


    /**
     * 设置顶部栏-左边图标
     * @param resid
     */
    protected void setBaseTopLeftImg(int resid) {
        ImageView ivBaseTopLeftImg = (ImageView) vgBaseTopLeft.findViewById(R.id.iv_top_left);
        try {
            ivBaseTopLeftImg.setImageResource(resid);
        } catch (Exception e) {
            L.e(e);
        }
    }

    protected void setBaseTopLeftImg(Bitmap bp) {
        ImageView ivBaseTopLeftImg = (ImageView) vgBaseTopLeft.findViewById(R.id.iv_top_left);
        try {
            ivBaseTopLeftImg.setImageBitmap(bp);
        } catch (Exception e) {
            L.e(e);
        }
    }

    /**
     * 设置顶部栏-右边图标
     * @param resid
     */
    protected void setVgBaseTopRighttImg(int resid) {
        ImageView ivBaseTopRightImg = (ImageView) vgBaseTopRight.findViewById(R.id.iv_top_right);
        try {
            ivBaseTopRightImg.setImageResource(resid);
        } catch (Exception e) {
            L.e(e);
        }
    }

}
