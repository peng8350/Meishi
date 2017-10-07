package com.peng.meishi.entity;

import android.support.annotation.DrawableRes;

/**
 * Created by peng on 16-10-10.
 */
public class StringIconInfo {
	private int title;
	private @DrawableRes int icon;

	public StringIconInfo(int title, int icon) {
		this.title = title;
		this.icon = icon;
	}

	public int getTitle() {

		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
}
