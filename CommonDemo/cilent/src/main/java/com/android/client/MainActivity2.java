package com.android.client;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.android.client.Fragment.home.HomeFragment;
import com.android.client.Fragment.others.CouponFragment;
import com.android.client.Fragment.user.UserFragment;
import com.android.lib.activity.BaseViewActivity;
import com.android.lib.custom.CustomViewPager;
import com.android.log.L;

import java.util.ArrayList;

public class MainActivity2 extends BaseViewActivity implements ViewPager.OnPageChangeListener{

    private ArrayList<Fragment> mFragments;
    public Fragment mHomeFragment, mCouponFragment, mUserFragment;


    public CustomViewPager mViewPager;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        setBvgBottomVisible(true);

        mHomeFragment = new HomeFragment();
        mCouponFragment = new CouponFragment();
        mUserFragment = new UserFragment();
        mFragments = new ArrayList<>();

        mFragments.add(mHomeFragment);
        mFragments.add(mCouponFragment);
        mFragments.add(mUserFragment);

        mViewPager = (CustomViewPager)findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(mFragments.size());
        // 给ViewPager设置适配器
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setScanScroll(true);
        int curpage = 0;
        mViewPager.setCurrentItem(curpage,false);// 设置当前显示标签页为第一页
        mViewPager.addOnPageChangeListener(this);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> list;
        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;

        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        L.v("onPageSelected"+position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
