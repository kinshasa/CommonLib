package net.xicp.liushaobo.cilent.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabHomePageIndicator;

import net.xicp.liushaobo.cilent.Fragment.home.HomeFragment;
import net.xicp.liushaobo.cilent.R;
import net.xicp.liushaobo.cilent.adapter.TablePagerAdapter;
import net.xicp.liushaobo.comlib.activity.BaseViewActivity;
import net.xicp.liushaobo.comlib.fragment.QuickFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录界面
 * Created by liusp@gagc.com.cn on 2016/6/29.
 */
public class HomeActivity extends BaseViewActivity {


    private ViewPager mPager;

    private TablePagerAdapter mAdapter;

    private TabHomePageIndicator mIndicator;

    /**
     * 显示ViewPage的布局
     */
    private List<Fragment> mFragments;

    /**
     * 显示ViewPage的标题
     */
    private String[] mTitles;

    /**
     * 显示ViewPage的图标
     */
    private int[] mIcons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);
        initView();
    }

    /**
     * 初始化页面
     */
    public void initView() {

        //初始化table文字
        mTitles = new String[]{
                getResources().getString(R.string.table_home),
                getResources().getString(R.string.table_new_car),
                getResources().getString(R.string.table_car_life),
                getResources().getString(R.string.table_find),
                getResources().getString(R.string.table_user),
        };
        //初始化table图标
        mIcons = new int[]{
                R.drawable.perm_group_calendar
        };

        setBaseTopLeftImg(R.drawable.ic_launcher);
        setVgBaseTopRighttImg(0);
        setBaseTopLabel(R.string.table_home);


        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new QuickFragment());
        mFragments.add(new QuickFragment());
        mFragments.add(new QuickFragment());

        mPager = (ViewPager) getContentView().findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(mFragments.size());

        mAdapter = new TablePagerAdapter(getSupportFragmentManager(), mFragments, mTitles, mIcons);
        mPager.setAdapter(mAdapter);

        mIndicator = (TabHomePageIndicator) getContentView().findViewById(R.id.indicator);
        mIndicator.setDirection(1);
        mIndicator.setViewPager(mPager);

    }

}
