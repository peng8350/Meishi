package com.peng.meishi.utils;

import com.peng.meishi.entity.MeishiInfo;
import com.peng.meishi.entity.PicFloatInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-12.
 */
public class AsymmUtils {

	public static List<PicFloatInfo> ConverttoPic(List<MeishiInfo> meishis,
			int[] width, int[] height) {
		List<PicFloatInfo> params = new ArrayList<>();
		for (int i = 0; i < width.length; i++) {
			// 带解决
			params.add(new PicFloatInfo(width[i], height[i], meishis.get(i)));

		}
		return params;
	}

}
