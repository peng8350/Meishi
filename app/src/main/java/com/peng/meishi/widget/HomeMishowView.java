package com.peng.meishi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;
import com.peng.meishi.R;
import com.peng.meishi.adapter.PicFloatAdapter;
import com.peng.meishi.entity.HomeMiddleInfo;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by peng on 16-10-12.
 */
@EViewGroup(R.layout.view_home_middle)
public class HomeMishowView extends RelativeLayout {
	@ViewById(R.id.view_HomeMiddle_title)
	TextView title_tv;
	@ViewById(R.id.view_HomeMiddle_Gridview)
	AsymmetricGridView grid_pic;
	// 操控数据源
	private HomeMiddleInfo dataSource;

	public HomeMishowView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HomeMishowView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public void setDataSource(HomeMiddleInfo dataSource) {

		this.dataSource = dataSource;
		grid_pic.setRequestedColumnCount(4);
		grid_pic.determineColumns();
		grid_pic.setRequestedHorizontalSpacing(20);
		title_tv.setText(dataSource.getTitle());
		PicFloatAdapter temp_adapter = new PicFloatAdapter(getContext(),
				R.layout.item_picfloat, dataSource.getDatas());
		AsymmetricGridViewAdapter adapter = new AsymmetricGridViewAdapter<>(
				getContext(), grid_pic, temp_adapter);
		grid_pic.setAdapter(adapter);
		grid_pic.setAllowReordering(true);
	}


	@Click(R.id.view_HomeMiddle_more)
	public void ClickMore() {

		// getContext().startActivity(dataSource.getIntent());
	}

}
