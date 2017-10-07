package com.peng.meishi.adapter;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.Contast;
import com.peng.meishi.entity.StringIconInfo;
import com.peng.meishi.utils.FrescoUtils;

import java.util.List;

/**
 * Created by peng on 16-10-12.
 */
public class AllKindAdapter extends QuickAdapter<StringIconInfo> {

    public AllKindAdapter(Context context, int layoutResId,
                          List<StringIconInfo> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, StringIconInfo item) {
        SimpleDraweeView image = helper.getView(R.id.item_home_allkind_image);
        FrescoUtils.Display(image, Contast.resource_Uri + item.getIcon(), 120,
                120, true);
        helper.setText(R.id.item_home_allkind_text,
                context.getString(item.getTitle()));
    }
}
