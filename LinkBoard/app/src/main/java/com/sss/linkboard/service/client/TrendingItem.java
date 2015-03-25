package com.sss.linkboard.service.client;

import com.google.gson.annotations.SerializedName;


public class TrendingItem {
    @SerializedName("title")
    private String title;

    public TrendingItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
