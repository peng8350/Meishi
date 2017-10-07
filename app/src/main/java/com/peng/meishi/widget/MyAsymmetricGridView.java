package com.peng.meishi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;

/**
 * Created by peng on 16-10-12.
 */
public class MyAsymmetricGridView extends AsymmetricGridView{

    public MyAsymmetricGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

				MeasureSpec.AT_MOST);

		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
