package com.peng.meishi.entity;

import com.orm.SugarRecord;

/**
 * Created by peng on 16-10-17.
 */

public class SearchInfo extends SugarRecord{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
