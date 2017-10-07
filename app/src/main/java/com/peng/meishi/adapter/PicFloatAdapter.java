package com.peng.meishi.adapter;

import java.util.List;

import com.blankj.utilcode.utils.ScreenUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.Contast;
import com.peng.meishi.entity.PicFloatInfo;
import com.peng.meishi.utils.FrescoUtils;

import android.content.Context;

/**
 * Created by peng on 16-10-12.
 */
public class PicFloatAdapter extends QuickAdapter<PicFloatInfo> {

	public PicFloatAdapter(Context context, int layoutResId,
			List<PicFloatInfo> data) {
		super(context, layoutResId, data);
	}

	@Override
	protected void convert(BaseAdapterHelper helper, PicFloatInfo item) {
		int rand = (int) (Math.random()*3)+1;
		helper.setText(R.id.item_picfloat_content, rand==1?"干炒牛河":rand==2?"香辣汉堡":"特色蛋糕");
		SimpleDraweeView image = helper.getView(R.id.item_picfloat_image);
		FrescoUtils.Display(image, "res://com.peng.meishi/"+ (rand==1?R.drawable.p14:rand==2?R.drawable.st18:R.drawable.st70),
				ScreenUtils.getScreenWidth(context) / 2,
				ScreenUtils.getScreenWidth(context) / 4, true);
	}
}
