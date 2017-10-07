package com.peng.meishi.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.TextView;
import com.blankj.utilcode.utils.ImageUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.peng.meishi.R;
import com.peng.meishi.adapter.MenuAdapter;
import com.peng.meishi.entity.StringIconInfo;
import com.special.ResideMenu.ResideMenu;
import net.qiujuer.genius.blur.StackBlur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-11.
 */
public class MainMenu extends ResideMenu {
    private SimpleDraweeView iv_head;
    private TextView tv_name;
    private TextView tv_intro;
    private GridView gv_data;


    private int[] title_res = {R.string.Menu_tab1, R.string.Menu_tab2,
            R.string.Menu_tab3, R.string.Menu_tab4, R.string.Menu_tab5,
            R.string.Menu_tab6};

    private int[] icon_res = {R.drawable.menu_icon1, R.drawable.menu_icon2,
            R.drawable.menu_icon3, R.drawable.menu_icon4, R.drawable.menu_icon5,
            R.drawable.menu_icon6};

    public MainMenu(Context context) {
        super(context);
        init();
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.menu_person, this);
        initPlugins();
        initDataSource();
    }

    /*
     * 初始化slidingmenu的数据源
     */
    private void initDataSource() {
        Bitmap b =StackBlur.blurNatively(BitmapFactory.decodeResource(getResources(),R.drawable.menu_bg), 60,
                 true);
        setBackground(new BitmapDrawable(b));
        tv_name = (TextView) findViewById(R.id.menu_name);
        tv_intro = (TextView) findViewById(R.id.menu_intro);
        gv_data = (GridView) findViewById(R.id.menu_Gridview);
        iv_head = (SimpleDraweeView) findViewById(R.id.menu_head);

        tv_name.setText("小明");
        tv_intro.setText("介绍");
        iv_head.setImageURI("res://com.peng.meishi/" + R.drawable.user_normal);
        gv_data.setAdapter(
                new MenuAdapter(getContext(), R.layout.item_menu, initData()));
    }

    /*
     * 初始化slidingmenu的配置
     */
    private void initPlugins() {

        setSwipeDirectionDisable(DIRECTION_LEFT);
        setShadowVisible(true);
        setScaleValue(0.45f);
    }

    private List<StringIconInfo> initData() {
        List<StringIconInfo> param = new ArrayList<>();

        for (int i = 0; i < title_res.length; i++) {
            StringIconInfo info = new StringIconInfo(title_res[i], icon_res[i]);

            param.add(info);
        }
        return param;
    }

}
