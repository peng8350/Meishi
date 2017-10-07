/*
 * this is Mr.Liang.author is 尐鹏,Android developer,
 * Hobby is play game,like War3,more and more.
 * will join into the github in the future
 */

package com.peng.meishi.activity.base;

import android.support.v7.app.AppCompatActivity;
import cn.bingoogolapple.titlebar.BGATitlebar;
import com.peng.meishi.R;
import com.peng.meishi.manager.MyApp;
import com.peng.meishi.utils.StatusBarUtil;
import org.androidannotations.annotations.App;

import static com.peng.meishi.R.color.navegive_color;

/**
 * Created by peng on 16-10-7.
 */
public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity";
    public BGATitlebar mTitleBar;

    protected  void init() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.navegive_color), 0);
        initTitleBar();

    }

    private void initTitleBar() {
        mTitleBar = (BGATitlebar) findViewById(R.id.titlebar);
        mTitleBar.setLeftText(getBackStr());
        mTitleBar.setDelegate(new BGATitlebar.BGATitlebarDelegate(){
            @Override
            public void onClickLeftCtv() {
                finish();
                super.onClickLeftCtv();
            }
        });
    }


    public abstract String getBackStr();

    public void setTitleText(String title) {
        mTitleBar.setTitleText(title);
    }

}
