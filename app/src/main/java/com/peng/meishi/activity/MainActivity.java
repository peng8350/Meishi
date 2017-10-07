/*
 * this is Mr.Liang.author is 尐鹏,Android developer,
 * Hobby is play game,like War3,more and more.
 * will join into the github in the future
 */

/*
 * this is Mr.Liang.author is 尐鹏,Android developer,
 * Hobby is play game,like War3,more and more.
 * will join into the github in the future
 */

package com.peng.meishi.activity;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.titlebar.BGATitlebar;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.rebound.SpringConfig;
import com.jpeng.jpspringmenu.SpringMenu;
import com.nineoldandroids.animation.ObjectAnimator;
import com.peng.meishi.R;
import com.peng.meishi.adapter.MainPagerAdapter;
import com.peng.meishi.fragment.Tab1Fragment_;
import com.peng.meishi.fragment.Tab2Fragment_;
import com.peng.meishi.fragment.Tab3Fragment_;
import com.peng.meishi.manager.MyApp;
import com.peng.meishi.utils.StatusBarUtil;
import com.peng.meishi.widget.MainMenu;
import com.special.ResideMenu.ResideMenu;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements OnTabItemSelectListener, ResideMenu.OnMenuListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "MAINACTIVITY";
    // 没有选中的图标
    private static final
    @DrawableRes
    int[] normal_icons = {
            R.drawable.tab1_normal, R.drawable.tab2_normal,
            R.drawable.tab3_normal};
    // 选中的图标
    private static final
    @DrawableRes
    int[] selected_icons = {
            R.drawable.tab1_selected, R.drawable.tab2_selected,
            R.drawable.tab3_selected};
    // 选中文字的颜色
    private static final int text_selected_color = MyApp.getInstance()
            .getResources().getColor(R.color.navegive_color);
    // 默认字体颜色
    private static final int text_normal_color = 0xffaeaeae;
    // 底部导航背景颜色
    private static final int tab_bg = R.drawable.tab_bg;
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;
    @ViewById(R.id.main_layout)
    RelativeLayout layout_main;
    @ViewById(R.id.main_titlebar)
    BGATitlebar titleBar;
    @ViewById(R.id.main_viewpager)
    ViewPager pagers;
    @ViewById(R.id.Main_bottomtab)
    PagerBottomTabLayout bottom_Bar;
    // 滑动菜单
    SpringMenu menu;
    String[] titles = {MyApp.getInstance().getString(R.string.Main_Tab1),
            MyApp.getInstance().getString(R.string.Main_Tab2),
            MyApp.getInstance().getString(R.string.Main_Tab3)};
    // 所有页面
    private List<Fragment> pager_list;
    // tabbar控制器
    private Controller controller;


    private ViewPager frag_pager;

    private BGABanner banner;


    @AfterViews
    public void init() {
        ImagePipeline pipeline = Fresco.getImagePipeline();
        pipeline.clearCaches();
        StatusBarUtil.setColor(this, getResources().getColor(R.color.navegive_color), 0);
        initTitleBar();
        initMenu();
        initFrags();
        initpager();

    }

    /*
     * 初始化标题栏
     */
    private void initTitleBar() {
        titleBar.setDelegate(new BGATitlebar.BGATitlebarDelegate() {
            @Override
            public void onClickRightCtv() {
                super.onClickRightCtv();
//                if (menu.isOpened()) {
//                    menu.closeMenu();
//                } else
//                    menu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }

            @Override
            public void onClickLeftCtv() {
                super.onClickLeftCtv();
                EnterSearchAct();
            }
        });
    }

    /*
    进入搜索界面
     */
    private void EnterSearchAct() {
        Intent intent = new Intent(this,SearchActivity_.class);
        startActivity(intent);
    }

    /*
     * 初始化滑动菜单
     */
    private void initMenu() {
        menu = new SpringMenu(this,R.layout.menu_person);
        menu.setMenuSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(30,3));
//        menu.attachToActivity(this);
//        menu.setMenuListener(this);

    }

    /***
     * 初始化viewpager和radiogroup
     */
    private void initpager() {
        // 适配viewpager的页面
        pagers.setAdapter(
                new MainPagerAdapter(getSupportFragmentManager(), pager_list));
        pagers.setOffscreenPageLimit(3);
        pagers.setOnPageChangeListener(this);
        // 构建导航栏,得到Controller进行后续控制
        /*
         * 创建TAB控制器
		 */
        bottom_Bar.setBackgroundResource(tab_bg);
        controller = bottom_Bar.builder()
                .addTabItem(normal_icons[0], selected_icons[0], titles[0],
                        text_selected_color)
                .addTabItem(normal_icons[1], selected_icons[1], titles[1],
                        text_selected_color)
                .addTabItem(normal_icons[2], selected_icons[2], titles[2],
                        text_selected_color)
                .setDefaultColor(text_normal_color).build();
        controller.addTabItemClickListener(this);
        onSelected(0, 2);
    }

    // 初始化fragment页面
    private void initFrags() {
        pager_list = new ArrayList<>();
        pager_list.add(new Tab1Fragment_());
        pager_list.add(new Tab2Fragment_());
        pager_list.add(new Tab3Fragment_());
    }


    // activity切换页面
    @Override
    public void onSelected(int index, Object tag) {
        pagers.setCurrentItem(index);
        titleBar.setTitleText(titles[index]);

    }

    /*
     * 当用户重复点击tabbar时所要执行的方法
     */
    @Override
    public void onRepeatClick(int index, Object tag) {

    }

    /*
     * 用户打开菜单后执行的方法
     */
    @Override
    public void openMenu() {
        Log.d(TAG, "openMenu: ");
        ObjectAnimator.ofFloat(titleBar.getRightCtv(), "rotation", 0F, -90F)
                .setDuration(200).start();
    }

    /*
     * 当residemenu关闭后要回调的函数
     */
    @Override
    public void closeMenu() {
        ObjectAnimator.ofFloat(titleBar.getRightCtv(), "rotation", 0F, 0)
                .setDuration(200).start();
    }

    /*
     * 重寫residemenu的觸摸事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return menu.dispatchTouchEvent(ev);
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); // 调用双击退出函数
        }
        return false;
    }

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, R.string.Press_exit, Toast.LENGTH_SHORT)
                    .show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

    public void setBanner(BGABanner banner) {
        this.banner = banner;

    }

    public void setFrag_pager(ViewPager frag_pager) {
        this.frag_pager = frag_pager;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (menu!=null) {
            menu.clearIgnoredViewList();
            if (position == 0) {
                menu.addIgnoredView(banner);
                Log.d(TAG, "onSelected: "+banner);
            } else if (position == 2) {
                menu.addIgnoredView(frag_pager);
                Log.d(TAG, "onSelected: "+frag_pager);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
