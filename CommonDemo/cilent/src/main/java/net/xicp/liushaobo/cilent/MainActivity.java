package net.xicp.liushaobo.cilent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import net.xicp.liushaobo.comlib.activity.BaseViewActivity;
import net.xicp.liushaobo.comlib.utils.log.L;
import net.xicp.liushaobo.comlib.view.custom.CustomViewPager;
import net.xicp.liushaobo.cilent.Fragment.home.HomeFragment;
import net.xicp.liushaobo.cilent.Fragment.others.CouponFragment;
import net.xicp.liushaobo.cilent.Fragment.user.UserFragment;

import java.util.ArrayList;

public class MainActivity extends BaseViewActivity implements ViewPager.OnPageChangeListener{

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
