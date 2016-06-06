package net.xicp.liushaobo.framedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.view.custom.CustomViewPager;
import net.xicp.liushaobo.framedemo.ui.home.CouponFragment;
import net.xicp.liushaobo.framedemo.ui.home.HomeFragment;
import net.xicp.liushaobo.framedemo.ui.home.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ArrayList<Fragment> mFragments;
    private Fragment mHomeFragment, mCouponFragment, mUserFragment;


    @ViewInject(R.id.viewpager)
    private CustomViewPager mViewPager;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LogUtils.allowI = true;
        ViewUtils.inject(this);

        mHomeFragment = new HomeFragment();
        mCouponFragment = new CouponFragment();
        mUserFragment = new UserFragment();
        mFragments = new ArrayList<>();

        mFragments.add(mHomeFragment);
        mFragments.add(mCouponFragment);
        mFragments.add(mUserFragment);
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
