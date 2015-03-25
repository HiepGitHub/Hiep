package com.sss.linkboard.service.client.tweet;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trongnhan on 3/17/15.
 */
public class UrlEntity implements Serializable{

    private List<UrlsEntity> urls;

    public void setUrls(List<UrlsEntity> urls) {
        this.urls = urls;
    }

    public List<UrlsEntity> getUrls() {
        return urls;
    }
}