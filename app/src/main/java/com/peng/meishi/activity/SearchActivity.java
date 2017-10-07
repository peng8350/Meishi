package com.peng.meishi.activity;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.peng.meishi.R;
import com.peng.meishi.adapter.SearchAdapter;
import com.peng.meishi.entity.MeishiInfo;
import com.peng.meishi.entity.SearchInfo;
import com.peng.meishi.entity.ShopInfo;
import com.peng.meishi.utils.StatusBarUtil;
import com.peng.meishi.widget.pinnedheaderlistview.PinnedHeaderListView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 16-10-17.
 */
@EActivity(R.layout.activity_search)
public class SearchActivity extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener, AdapterView.OnItemClickListener {
    @ViewById(R.id.Search_searchbox)
    MaterialSearchView mSearchBox;
    @ViewById(R.id.Search_listview)
    PinnedHeaderListView mListView;


    private List<MeishiInfo> mMeishis;
    private List<ShopInfo> mShops;
    private List<String> mSuggestions;
    private SearchAdapter mAdapter;

    @AfterViews
    public void init() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.navegive_color), 0);

        mSearchBox.showSearch();
        List<SearchInfo> Seaches = SearchInfo.findWithQuery(SearchInfo.class, "select * from SEARCH_INFO order by id desc");
        mSuggestions = new ArrayList<>();
        for (SearchInfo info : Seaches) {
            mSuggestions.add(info.getTitle());
        }
        if (mSuggestions != null && mSuggestions.size() > 0)
            mSearchBox.setSuggestions(mSuggestions.toArray(new String[Seaches.size()]));
        mSearchBox.setOnQueryTextListener(this);
        mSearchBox.setOnSearchViewListener(this);
        mSearchBox.setOnItemClickListener(this);
        initList();
    }


    private void initList() {
        mMeishis = new ArrayList<>();
        mShops = new ArrayList<>();
        mAdapter =new SearchAdapter(mMeishis,mShops,this);
        mListView.setAdapter(mAdapter);
    }


    @Override
    public void onBackPressed() {
        if (mSearchBox.isSearchOpen()) {
            mSearchBox.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && !mSearchBox.isSearchOpen()) {

            mSearchBox.showSearch();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    mSearchBox.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        SaveStr(query);
        return false;
    }

    private void SaveStr(String query) {
        mSearchBox.closeSearch();

        SearchInfo info = new SearchInfo();
        info.setTitle(query);
        info.save();
        mSuggestions.add(0, info.getTitle());

        mSearchBox.setSuggestions(mSuggestions.toArray(new String[mSuggestions.size()]));
        info = null;

        SearchDataFromNet();
    }

    /*
    从网络捕获数据
     */
    private void SearchDataFromNet() {

        mMeishis.clear();
        mShops.clear();
        for (int i = 0; i < 20; i++) {
            MeishiInfo info1 = new MeishiInfo("阿斯顿", "我全额", 0);
            info1.setIntro("qwe");
            info1.setPlace("qwewqeq");
            info1.setMoney("45-90");
            info1.setScore((float) 8.8);
            mMeishis.add(info1);
            ShopInfo info2 = new ShopInfo(0, "我全额", "15015715140", "11:30-18:30");
            mShops.add(info2);
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    @Override
    public void onSearchViewShown() {
        mListView.setVisibility(View.GONE);
    }

    @Override
    public void onSearchViewClosed() {
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String str = mSuggestions.get(position);
        mSearchBox.setQuery(str,true);
    }
}
