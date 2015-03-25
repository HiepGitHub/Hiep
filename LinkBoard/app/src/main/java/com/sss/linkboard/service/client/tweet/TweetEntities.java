package com.sss.linkboard.service.client.tweet;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trongnhan on 3/17/15.
 */
public class TweetEntities {

    private List<UrlsEntity> urls;

    @SerializedName("user_mentions")
    private List<UserMentions> user_mentions;

    public List<UrlsEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlsEntity> urls) {
        this.urls = urls;
    }

    public List<UserMentions> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(List<UserMentions> user_mentions) {
        this.user_mentions = user_mentions;
    }

    public class UserMentions{
        private String id;
        private String name;
        private List<String> indices;
        private String screen_name;
        private String id_str;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setIndices(List<String> indices) {
            this.indices = indices;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<String> getIndices() {
            return indices;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public String getId_str() {
            return id_str;
        }
    }
}
