package com.sss.linkboard.service.client.tweet;

import java.io.Serializable;
import java.util.List;

/**
 * Created by trongnhan on 3/17/15.
 */
public class TweetUserEntities implements Serializable{
    private DescriptionEntity description;
    private UrlEntity url;

    public void setDescription(DescriptionEntity description) {
        this.description = description;
    }

    public void setUrl(UrlEntity url) {
        this.url = url;
    }

    public DescriptionEntity getDescription() {
        return description;
    }

    public UrlEntity getUrl() {
        return url;
    }

    public class DescriptionEntity {

        private List<UrlsEntity> urls;

        public void setUrls(List<UrlsEntity> urls) {
            this.urls = urls;
        }

        public List<UrlsEntity> getUrls() {
            return urls;
        }
    }
}
