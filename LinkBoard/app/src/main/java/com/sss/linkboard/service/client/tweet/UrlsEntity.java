package com.sss.linkboard.service.client.tweet;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trongnhan on 3/17/15.
 */
public class UrlsEntity implements Serializable{
    private String expanded_url;
    private List<String> indices;
    private String display_url;
    private String url;

    public void setExpanded_url(String expanded_url) {
        this.expanded_url = expanded_url;
    }

    public void setIndices(List<String> indices) {
        this.indices = indices;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpanded_url() {
        return expanded_url;
    }

    public List<String> getIndices() {
        return indices;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public String getUrl() {
        return url;
    }
}
