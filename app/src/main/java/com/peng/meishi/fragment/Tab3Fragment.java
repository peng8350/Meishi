package com.peng.meishi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.LinearLayout;
import com.peng.meishi.R;
import com.peng.meishi.activity.MainActivity;
import com.peng.meishi.widget.PagerSlidingTabStrip;
import com.peng.meishi.widget.SimpleViewPagerIndicator;
import com.peng.meishi.widget.StickyNavLayout;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static android.R.attr.banner;
import static android.R.attr.logo;

/**
 * Created by peng on 16-10-8.
 */
@EFragment(R.layout.fragment_main3)
public class Tab3Fragment extends Fragment{
    private static final String TAG = "Tag3Fragment";

    private String[] mTitles = new String[] { "附近美食", "附近店铺" };

    private FragmentPagerAdapter mAdapter;

    private NearFragment_[] mNears_frag = new NearFragment_[2];
    @ViewById(R.id.id_stickynavlayout_indicator)
    PagerSlidingTabStrip mLayoutIndicator;
    @ViewById(R.id.id_stickynavlayout_viewpager)
    ViewPager mPager;

    @ViewById(R.id.frag3_sticklayout)
    StickyNavLayout mNav;

    /*
     * 实现fragment的初始化布局
     */
    @AfterViews
    public void initViews() {
        
        initPagers();
        initInctor();
    }

    /*
        初始化指示器
     */
    private void initInctor() {
        mLayoutIndicator.setViewPager(mPager); // 这是其所handle的ViewPager

        mLayoutIndicator.setUnderlineHeight(3); // 设置标签栏下边的间隔线高度，单位像素
        mLayoutIndicator.setShouldExpand(true);
        mLayoutIndicator.setIndicatorColorResource(R.color.navegive_color);
        mLayoutIndicator.setTextColorResource(R.color.black);
        mLayoutIndicator.setSelectedTextColorResource(R.color.navegive_color);
        mLayoutIndicator.setIndicatorHeight(6); // 设置Indicator 游标 高度，单位像素
    }


    /*
    初始化页面数据
     */
    private void initPagers() {
        for (int i = 0; i < mTitles.length; i++)
        {
            mNears_frag[i] = new NearFragment_();
            Bundle bundle = new Bundle();
            bundle.putInt("type",i);
            mNears_frag[i].setArguments(bundle);
        }
        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mNears_frag[position];
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

            @Override
            public int getCount() {
                return mNears_frag.length;
            }
        };
        mPager.setAdapter(mAdapter);
        ((MainActivity)getActivity()).setFrag_pager(mPager);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.d(TAG, "onHiddenChanged: ");
        super.onHiddenChanged(hidden);
    }

    @Click(R.id.tv_frag3_top1)
    public void ClickT1(){

    }

    @Click(R.id.tv_frag3_top2)
    public void ClickT2(){

    }

    @Click(R.id.tv_frag3_top3)
    public void ClickT3(){

    }


}
