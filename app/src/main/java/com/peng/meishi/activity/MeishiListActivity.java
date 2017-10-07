package com.peng.meishi.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.peng.meishi.R;
import com.peng.meishi.activity.base.BaseActivity;
import com.peng.meishi.adapter.GirdDropDownAdapter;
import com.peng.meishi.adapter.MeishiListAdapter;
import com.peng.meishi.entity.MeishiInfo;
import com.yyydjk.library.DropDownMenu;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.*;

/**
 * Created by peng on 16-10-17.
 */
@EActivity(R.layout.activity_list_meishi)
public class MeishiListActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    //标题
    public static final String[] mTitles = {"距离", "评分", "价钱"};

    //第一种类型的数据选择
    private static final String[] mT1_list = {"500米以内", "1000米以内", "2000米以内", "5000米以内", "不限"};
    //第二种
    private static final String[] mT2_list = {"9分以上", "8~9", "7~8", "不限"};
    //第三种
    private static final String[] mT3_list = {"50~100", "100~200", "20~50", "0~20", "不限"};

    private static final String[][] mTList = {mT1_list, mT2_list, mT3_list};

    private ListView[] mMenuList = new ListView[3];
    //数据集合
    private List<HashMap<String, Object>> mMenuDatas;

    @Extra("title")
    String extra_title;
    @Extra("type")
    int extra_type;

    @ViewById(R.id.activity_list_meishi_dropDownMenu)
    DropDownMenu mMenu;

    private ListView mListView;

    private List<MeishiInfo> mMeishis;

    @AfterViews
    public void init() {
        super.init();
        setTitleText(extra_title);
        initListView();
        initViewData();
        initMenu();
    }

    private void initViewData() {
        mMenuList[0] = new ListView(this);
        GirdDropDownAdapter M1Adapter = new GirdDropDownAdapter(this, Arrays.asList(mT1_list));
        mMenuList[0].setDividerHeight(0);
        mMenuList[0].setAdapter(M1Adapter);
        mMenuList[0].setOnItemClickListener(this);
        //init age menu
        mMenuList[1] = new ListView(this);
        mMenuList[1].setDividerHeight(0);
        GirdDropDownAdapter M2Adapter = new GirdDropDownAdapter(this, Arrays.asList(mT2_list));
        mMenuList[1].setAdapter(M2Adapter);
        mMenuList[1].setOnItemClickListener(this);
        //init sex menu
        mMenuList[2] = new ListView(this);
        mMenuList[2].setDividerHeight(0);
        GirdDropDownAdapter M3Adapter = new GirdDropDownAdapter(this, Arrays.asList(mT3_list));
        mMenuList[2].setAdapter(M3Adapter);
        mMenuList[2].setOnItemClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mMenu.isShowing()) {
            mMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    /*
        初始化赛选菜单
         */
    private void initMenu() {
        mMenu.setDropDownMenu(Arrays.asList(mTitles), Arrays.<View>asList(mMenuList), mListView);
    }

    /*
    初始化列表数据
     */
    private void initListView() {
        mListView = (ListView) getLayoutInflater().from(this).inflate(R.layout.view_list_meishi, null);
        mMeishis = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            int rand = (int)(Math.random()*5)+1;
            MeishiInfo info = new MeishiInfo(rand==1?"干炒牛河":rand==2?"美色甜品":rand==3?"炒米粉":"越式美食", "介绍", 0);
            info.setMoney(rand==1?"34":rand==2?"24":rand==3?"98":rand==4?"47":"80");
            info.setPlace(rand==1?"广东佛山":rand==2?"广东广州":rand==3?"广东珠海":rand==4?"广东佛山":"广东广州");
            info.setPingjia("很好很好");
            info.setScore((float) 7.5);
            mMeishis.add(info);
        }

        mListView.setAdapter(new MeishiListAdapter(this, R.layout.item_meishi, mMeishis));

    }

    @Override
    public String getBackStr() {

        return "主界面";
    }

    //封装Menu点击
    public void ClickMenuList(int pos, int Columnpos) {
        GirdDropDownAdapter adapter = (GirdDropDownAdapter) mMenuList[pos].getAdapter();
        adapter.setCheckItem(Columnpos);
        mMenu.setTabText(Columnpos == 0 ? mTitles[pos] : adapter.getList().get(Columnpos));
        mMenu.closeMenu();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == mMenuList[0]) {
            ClickMenuList(0, position);
        } else if (parent == mMenuList[1]) {
            ClickMenuList(1, position);
        } else {
            ClickMenuList(2, position);
        }

    }
}
