package com.peng.meishi.adapter;

import android.content.Context;
import android.widget.RatingBar;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.MeishiInfo;
import com.peng.meishi.utils.FrescoUtils;

import java.util.List;

/**
 * Created by peng on 16-10-16.
 */
public class MeishiListAdapter extends QuickAdapter<MeishiInfo> {

    public MeishiListAdapter(Context context, int layoutResId, List<MeishiInfo> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, MeishiInfo item) {
        SimpleDraweeView mImage =helper.getView(R.id.item_meishi_image);
        SimpleRatingBar mRatingBar = helper.getView(R.id.item_meishi_ratingbar);
        helper.setText(R.id.item_meishi_place,item.getPlace());
        helper.setText(R.id.item_meishi_score,"("+item.getScore()+"分)");
        helper.setText(R.id.item_Meishi_pingjia,item.getPingjia());
        helper.setText(R.id.item_meishi_money,item.getMoney());
        helper.setText(R.id.item_meishi_title,item.getTitle());
        mRatingBar.setRating((float)(item.getScore()/2));
        int rand = (int)(Math.random()*5)+1;
        FrescoUtils.Display(mImage,"res:///"+(rand==1?R.drawable.p1:rand==2?R.drawable.p24:rand==3?R.drawable.p13:rand==4?R.drawable.p15:R.drawable.p18),220,220,true);
    }
}
