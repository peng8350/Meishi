package com.peng.meishi.adapter;

import android.content.Context;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.entity.MyBean;

import java.util.List;

/**
 * Created by peng on 16-10-9.
 */
public class TestAdapter extends QuickAdapter<MyBean> {
	private Context context;

	public TestAdapter(Context context, int layoutResId, List<MyBean> data) {
		super(context, layoutResId, data);
	}

	@Override
	protected void convert(BaseAdapterHelper helper, MyBean item) {

	}
}
