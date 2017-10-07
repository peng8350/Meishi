package com.peng.meishi.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.blankj.utilcode.utils.ScreenUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.peng.meishi.R;
import com.peng.meishi.activity.MainActivity;
import com.peng.meishi.activity.MeishiListActivity;
import com.peng.meishi.activity.MeishiListActivity_;
import com.peng.meishi.adapter.AllKindAdapter;
import com.peng.meishi.entity.Contast;
import com.peng.meishi.entity.HomeMiddleInfo;
import com.peng.meishi.entity.PicFloatInfo;
import com.peng.meishi.entity.StringIconInfo;
import com.peng.meishi.utils.FrescoUtils;
import com.peng.meishi.utils.StringIconParser;
import com.peng.meishi.widget.HomeMishowView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.Arrays;
import java.util.List;

@EFragment(R.layout.fragment_main1)
public class Tab1Fragment extends Fragment {

    private static final String TAG = "TAB1fragment";
    // 数据ID
    private static final Integer[] icons_banner = {R.drawable.p8,
            R.drawable.st70, R.drawable.p181, R.drawable.p14, R.drawable.p15,
            R.drawable.p13, R.drawable.p24, R.drawable.p22};
    // 数据字符串列表
    private static final String[] titles_banner = {"阿斯顿饼干", "阿斯顿蛋糕", "调你蛋糕",
            "干炒牛河", "特色剪饺", "炒鱿鱼", "特色蛋糕", "眩辣青菜"};
    // 种类图片大全
    private static final int[] icons_kinds = {R.drawable.meishi1,
            R.drawable.meishi2, R.drawable.meishi3, R.drawable.meishi4,
            R.drawable.meishi1, R.drawable.meishi2};
    // 种类字符串
    private static final int[] titles_kinds = {R.string.Mkind1,
            R.string.Mkind2, R.string.Mkind3, R.string.Mkind4, R.string.Mkind5,
            R.string.Mkind6};
    // banner
    @ViewById(R.id.frag1_bannner)
    BGABanner banner;
    @ViewById(R.id.frag1_middle1)
    HomeMishowView middle1;
    @ViewById(R.id.frag1_middle2)
    HomeMishowView middle2;
    @ViewById(R.id.frag1_middle3)
    HomeMishowView middle3;
    @ViewById(R.id.frag1_allkind)
    GridView gv_kind;

    @AfterViews
    public void init() {
        setData();
        initBanner();
        initMiddle();
    }

    // 设置数据
    public void setData() {
        HomeMiddleInfo info1 = new HomeMiddleInfo();
        info1.setTitle(getActivity().getString(R.string.Home_m1));
        info1.setDatas(Arrays.asList(new PicFloatInfo(2, 2, null),
                new PicFloatInfo(2, 1, null), new PicFloatInfo(2, 1, null)));
        HomeMiddleInfo info2 = new HomeMiddleInfo();
        info2.setTitle(getActivity().getString(R.string.Home_m2));
        info2.setDatas(Arrays.asList(new PicFloatInfo(2, 1, null),
                new PicFloatInfo(2, 1, null), new PicFloatInfo(4, 2, null)));
        HomeMiddleInfo info3 = new HomeMiddleInfo();
        info3.setTitle(getActivity().getString(R.string.Home_m3));
        info3.setDatas(Arrays.asList(new PicFloatInfo(2, 1, null),
                new PicFloatInfo(2, 2, null), new PicFloatInfo(2, 1, null)));
        middle1.setDataSource(info1);
        middle2.setDataSource(info2);
        middle3.setDataSource(info3);
    }


    // 初始化图片播放器
    private void initBanner() {
        banner.setAdapter(new BGABanner.Adapter() {

            @Override
            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                FrescoUtils.Display((SimpleDraweeView) view, Contast.resource_Uri + (int) model, ScreenUtils.getScreenWidth(getActivity()), 400, true);
            }
        });
        banner.setData(R.layout.item_pic, Arrays.asList(icons_banner), Arrays.asList(titles_banner));
        Log.d(TAG, "initBanner: "+banner);
        ((MainActivity) getActivity()).setBanner(banner);

    }

    // 初始化中部的图片展示
    private void initMiddle() {
        List<StringIconInfo> Kinds_bean = StringIconParser
                .paserStringIcon(icons_kinds, titles_kinds);
        gv_kind.setAdapter(new AllKindAdapter(getActivity(),
                R.layout.item_home_allkind, Kinds_bean));
    }

    @ItemClick
    void frag1_allkind(int pos){
        Intent intent = new Intent(getActivity(), MeishiListActivity_.class);
        intent.putExtra("title",getString(titles_kinds[pos]));
        intent.putExtra("type",pos);
        startActivity(intent);
    }

}
