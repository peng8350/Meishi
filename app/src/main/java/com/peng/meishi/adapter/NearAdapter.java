package com.peng.meishi.adapter;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.NearInfo;
import com.peng.meishi.utils.FrescoUtils;

import java.util.List;

/**
 * Created by peng on 16-10-15.
 */
public class NearAdapter extends QuickAdapter<NearInfo> {


    public NearAdapter(Context context, int layoutResId, List<NearInfo> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, NearInfo item) {
        helper.setText(R.id.item_meishi_title,item.getName());
        helper.setText(R.id.item_Meishi_pingjia,item.getPlace());
        helper.setText(R.id.item_near_distance,"2.36km");
        helper.setText(R.id.item_meishi_score,"("+item.getScope()+"分)");
        //头像
        int id =0;
        try {
            try {
              id =    Integer.parseInt(R.drawable.class.getField("t"+((int)(Math.random()*5)+1)).get(null).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        SimpleDraweeView mImage = helper.getView(R.id.item_meishi_image);
        SimpleRatingBar mRatingBar=helper.getView(R.id.item_meishi_ratingbar);
        //1为美食,2为店铺
        FrescoUtils.Display(mImage,"res:///"+id,240,180,true);
//        mRatingBar.set
        mRatingBar.setRating((float)(item.getScope()/2));
//        int type = item.getType();
//        if (type==1){
//
//        }
//        else{
//
//        }
    }
}
