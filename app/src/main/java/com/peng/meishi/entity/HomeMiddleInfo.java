package com.peng.meishi.entity;

import java.util.List;

import android.content.Intent;

/**
 * Created by peng on 16-10-12.
 */
public class HomeMiddleInfo {

	private String title;
	private List<PicFloatInfo> datas;
	private Intent intent;

	public HomeMiddleInfo(String title, List<PicFloatInfo> datas,
			Intent intent) {
		this.title = title;
		this.datas = datas;
		this.intent = intent;
	}

	public HomeMiddleInfo() {

	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PicFloatInfo> getDatas() {
		return datas;
	}

	public void setDatas(List<PicFloatInfo> datas) {
		this.datas = datas;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

}
