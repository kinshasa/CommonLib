package com.android.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

import java.util.List;

/**
 * Created by liusp@gagc.com.cn on 2016/6/29.
 */
public class TablePagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private List<Fragment> mFragments;
    private int[] mIcons;
    private String[] mTitles;

    public TablePagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titls, int[] icons) {
        super(fm);
        mFragments = fragments;
        mTitles = titls;
        mIcons = icons;

        if(mIcons == null){
            mIcons = new int[]{};
        }
        if(mTitles == null){
            mTitles = new String[]{};
        }
    }


    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (mTitles==null||mTitles.length==0)?"":mTitles[position % mTitles.length];
    }

    @Override
    public int getIconResId(int i) {

        return (mIcons==null||mIcons.length==0)?0:mIcons[i % mIcons.length];
    }

    public int getCount() {
        return mFragments.size();
    }
}
