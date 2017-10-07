package com.peng.meishi.fragment;

import android.support.v4.app.Fragment;
import com.joanzapata.android.QuickAdapter;
import com.peng.meishi.R;
import com.peng.meishi.adapter.ShopListAdapter;
import com.peng.meishi.entity.ShopInfo;
import com.peng.meishi.widget.Xview.XListView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-8.
 */
@EFragment(R.layout.fragment_main2)
public class Tab2Fragment extends Fragment
		implements XListView.IXListViewListener {
	private static final String TAG = "Tab2Fragment";
	@ViewById(R.id.frag_main2_MultiColumnListView)
	XListView columnListView;

	List<ShopInfo> list;

	private QuickAdapter<ShopInfo> adapter;

	/*
	 * 实现fragment的初始化布局
	 */
	@AfterViews
	public void initViews() {
		adapter = new ShopListAdapter(getActivity(), R.layout.item_frag2_shop,
				getData());

		columnListView.setAdapter(adapter);
		columnListView.setPullRefreshEnable(false);
		columnListView.setPullLoadEnable(true);
		columnListView.setXListViewListener(this);
	}

	private List<ShopInfo> getData() {
		list = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			list.add(new ShopInfo());
		}
		return list;
	}

	@Override
	public void onRefresh() {

	}

	@Override
	public void onLoadMore() {
		for (int i = 0; i < 20; i++) {
			adapter.add(new ShopInfo());
		}
		columnListView.stopLoadMore();
	}
}
