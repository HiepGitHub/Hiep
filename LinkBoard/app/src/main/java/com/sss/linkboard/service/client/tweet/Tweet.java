package com.sss.linkboard.service.client.tweet;

import java.io.Serializable;

/**
 * Created by trongnhan on 3/17/15.
 */
public class Tweet implements Serializable{
    private TweetMetaData metadata;

    private String id;
    private String text;
    private String in_reply_to_user_id_str;
    private String source;
    private String in_reply_to_screen_name;
    private String in_reply_to_status_id;
    private String in_reply_to_user_id;
    private String created_at;
    private boolean truncated;
    private String id_str;
    private String in_reply_to_status_id_str;

    private TweetUser user;


    private Tweet retweeted_status;

    private String contributors;
    private String geo;
    private int retweet_count;
    private int favorite_count;
    private String place;
    private String coordinates;

    private TweetEntities entities;

    private boolean retweeted;
    private boolean favorited;
    private boolean possibly_sensitive;
    private String lang;


    public TweetMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(TweetMetaData metadata) {
        this.metadata = metadata;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public String getSource() {
        return source;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public String getId_str() {
        return id_str;
    }

    public String getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getContributors() {
        return contributors;
    }

    public String getGeo() {
        return geo;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public String getPlace() {
        return place;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setPossibly_sensitive(boolean possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public boolean isPossibly_sensitive() {
        return possibly_sensitive;
    }

    public String getLang() {
        return lang;
    }

    public TweetUser getUser() {
        return user;
    }

    public void setUser(TweetUser user) {
        this.user = user;
    }

    public TweetEntities getEntities() {
        return entities;
    }

    public void setEntities(TweetEntities entities) {
        this.entities = entities;
    }

    public Tweet getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Tweet retweeted_status) {
        this.retweeted_status = retweeted_status;
    }
}
