package com.peng.meishi.utils;

import com.peng.meishi.entity.StringIconInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-12.
 */
public class StringIconParser {

	/*
	 * 传入String和icon的数组,直接转换为你缩要的 List<Stringicon>
	 */
	public static List<StringIconInfo> paserStringIcon(int[] titles,
			int[] icons) {
		List<StringIconInfo> params = new ArrayList<>();
		for (int i = 0; i < titles.length; i++) {
			StringIconInfo info = new StringIconInfo(icons[i], titles[i]);
			params.add(info);
		}

		return params;
	}
}
