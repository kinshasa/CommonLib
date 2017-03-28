package com.android.client;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.android.client.Fragment.home.HomeFragment;
import com.android.client.Fragment.others.CouponFragment;
import com.android.client.Fragment.user.UserFragment;
import com.android.client.viewpager.APSTSViewPager;
import com.android.lib.activity.BaseViewActivity;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;

/**
 * Created by lshaobocsu@gmail.com on 2017.3.27.
 */

public class MainActivity extends BaseViewActivity implements ViewPager.OnPageChangeListener {


    public AdvancedPagerSlidingTabStrip mAPSTS;
    public APSTSViewPager mVP;

    private static final int VIEW_FIRST = 0;
    private static final int VIEW_SECOND = 1;
    private static final int VIEW_THIRD = 2;
    private static final int VIEW_FOURTH = 3;

    private static final int VIEW_SIZE = 4;

    public Fragment mHomeFragment, mCouponFragment,mCouponFragment2, mUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        init();
    }

    private void findViews() {
        mAPSTS = (AdvancedPagerSlidingTabStrip) findViewById(R.id.tabs);
        mVP = (APSTSViewPager) findViewById(R.id.vp_main);
    }

    private void init() {

        setBvgBottomVisible(false);
        mVP.setOffscreenPageLimit(VIEW_SIZE);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        mVP.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        adapter.notifyDataSetChanged();
        mAPSTS.setViewPager(mVP);
        mAPSTS.setOnPageChangeListener(this);
        mVP.setCurrentItem(VIEW_FIRST);
        mAPSTS.showDot(VIEW_FIRST, "99+");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class FragmentAdapter extends FragmentStatePagerAdapter implements AdvancedPagerSlidingTabStrip.IconTabProvider {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        if (null == mHomeFragment)
                            mHomeFragment = new HomeFragment();
                        return mHomeFragment;

                    case VIEW_SECOND:
                        if (null == mCouponFragment)
                            mCouponFragment = new CouponFragment();
                        return mCouponFragment;

                    case VIEW_THIRD:
                        if (null == mCouponFragment2)
                            mCouponFragment2 = new CouponFragment();
                        return mCouponFragment2;

                    case VIEW_FOURTH:
                        if (null == mUserFragment)
                            mUserFragment = new UserFragment();
                        return mUserFragment;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return VIEW_SIZE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return "first";
                    case VIEW_SECOND:
                        return "second";
                    case VIEW_THIRD:
                        return "third";
                    case VIEW_FOURTH:
                        return "fourth";
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public Integer getPageIcon(int index) {
            if (index >= 0 && index < VIEW_SIZE) {
                switch (index) {
                    case VIEW_FIRST:
                        return R.mipmap.home_main_icon_n;
                    case VIEW_SECOND:
                        return R.mipmap.home_categry_icon_n;
                    case VIEW_THIRD:
                        return R.mipmap.home_live_icon_n;
                    case VIEW_FOURTH:
                        return R.mipmap.home_mine_icon_n;
                    default:
                        break;
                }
            }
            return 0;
        }

        @Override
        public Integer getPageSelectIcon(int index) {
            if (index >= 0 && index < VIEW_SIZE) {
                switch (index) {
                    case VIEW_FIRST:
                        return R.mipmap.home_main_icon_f_n;
                    case VIEW_SECOND:
                        return R.mipmap.home_categry_icon_f_n;
                    case VIEW_THIRD:
                        return R.mipmap.home_live_icon_f_n;
                    case VIEW_FOURTH:
                        return R.mipmap.home_mine_icon_f_n;
                    default:
                        break;
                }
            }
            return 0;
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return null;
        }
    }
}
