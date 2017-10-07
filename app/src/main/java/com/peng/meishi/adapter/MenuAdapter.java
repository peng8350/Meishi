package com.peng.meishi.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.StringIconInfo;

import java.util.List;

/**
 * Created by peng on 16-10-10.
 */
public class MenuAdapter extends QuickAdapter<StringIconInfo> {

    public MenuAdapter(Context context, int layoutResId,
                       List<StringIconInfo> data) {
        super(context, layoutResId, data);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void convert(BaseAdapterHelper helper, StringIconInfo item) {
        TextView content_tv = helper.getView(R.id.item_menu_content);
        content_tv.setText(item.getTitle());
        Drawable icon_drawable = context.getResources()
                .getDrawable(item.getIcon());
        content_tv.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                icon_drawable, null, null);
    }

}
