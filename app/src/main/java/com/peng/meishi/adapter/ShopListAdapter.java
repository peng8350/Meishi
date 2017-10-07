package com.peng.meishi.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.blankj.utilcode.utils.ScreenUtils;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.entity.ShopInfo;
import com.peng.meishi.utils.FrescoUtils;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by peng on 16-10-11.
 */
public class ShopListAdapter extends QuickAdapter<ShopInfo> {

	public ShopListAdapter(Context context, int layoutId,
			List<ShopInfo> datas) {
		super(context, layoutId, datas);
	}

	@Override
	protected void convert(BaseAdapterHelper helper, ShopInfo item) {

		final SimpleDraweeView iv_shop = helper
				.getView(R.id.item_shop_search_pic);
		int resid = 0;
		int rand = ((int) (Math.random() * 5) + 1);
		try {
			resid = Integer.parseInt(R.drawable.class
					.getField("t" + rand)
					.get(null).toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		helper.setText(R.id.item_frag2_shop_name,rand==1?"胜利美食":rand==2?"Ghoset":rand==3?"北京美食":rand==4?"粤室饭店":"奇特点品");
		helper.setText(R.id.item_shop_search_time,rand==1?"1501548965":rand==2?"1697465621":rand==3?"13184965217":rand==4?"15369482159":"1687425697");
		helper.setText(R.id.item_frag2_shop_intro,"这是一个很好的店铺哦,请多多关照!");
		FrescoUtils.Display(iv_shop, "res://com.peng.meishi/" + resid,
				ScreenUtils.getScreenWidth(context), 300, true,
				new BaseControllerListener<ImageInfo>() {

					@Override
					public void onFinalImageSet(String id,
							@Nullable ImageInfo imageInfo,
							@Nullable Animatable animatable) {
						int width = imageInfo.getWidth();
						int height = imageInfo.getHeight();
						float ratio = (float) width / (float) height;
						iv_shop.setAspectRatio(ratio);
						super.onFinalImageSet(id, imageInfo, animatable);
					}
				});
	}

}
