package com.peng.meishi.fragment;

import android.support.v4.app.Fragment;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.peng.meishi.R;
import com.peng.meishi.adapter.NearAdapter;
import com.peng.meishi.entity.NearInfo;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-15.
 */
@EFragment(R.layout.fragment_near)
public class NearFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2<PullToRefreshListView> {
    private static final String TAG = "nearfragment";
    @ViewById(R.id.id_stickynavlayout_innerscrollview)
    PullToRefreshListView mListView;

    private List<NearInfo> mDatas;

    @AfterViews
    public void init() {
        //初始化家属解决
        initRefresh();
        initData();
    }

    private void initRefresh() {
        mListView.getLoadingLayoutProxy(false, true).setPullLabel(getActivity().getString(R.string.pullup_pull));
        mListView.setRefreshingLabel(getActivity().getString(R.string.pullup_refresh));
        mListView.setReleaseLabel(getActivity().getString(R.string.pullup_release));
    }

    private void initData() {

        mDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            NearInfo info = new NearInfo(1, i%5==1?"胜利美食":i%5==2?"美好甜品":i%5==3?"友好美食":"完美美食", 1, (float) 8.5, "广东 佛山", 0, 1);
            mDatas.add(info);
        }
        mListView.setAdapter(new NearAdapter(getActivity(), R.layout.item_near, mDatas));
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<PullToRefreshListView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<PullToRefreshListView> refreshView) {

    }
}
