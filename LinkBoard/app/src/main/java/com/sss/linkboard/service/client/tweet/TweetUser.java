package com.sss.linkboard.service.client.tweet;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by trongnhan on 3/17/15.
 */
public class TweetUser implements Serializable{

    private String id;
    private String profile_location;
    private String location;
    private String description;
    private String name;
    private String screen_name;
    private String id_str;
    private String url;

    private TweetUserEntities entities;

    @SerializedName("protected")
    private boolean _protected;


    private boolean default_profile;
    private int statuses_count;
    private boolean profile_background_tile;
    private String lang;
    private String profile_link_color;
    private String following;
    private int favourites_count;
    private String profile_text_color;
    private boolean contributors_enabled;
    private boolean verified;
    private String profile_sidebar_border_color;
    private String profile_background_color;
    private String created_at;
    private boolean is_translation_enabled;
    private boolean default_profile_image;
    private int followers_count;
    private boolean geo_enabled;
    private String profile_image_url_https;
    private String profile_background_image_url;
    private String profile_background_image_url_https;
    private String follow_request_sent;
    private String utc_offset;
    private String time_zone;
    private String notifications;
    private int friends_count;
    private boolean profile_use_background_image;
    private String profile_sidebar_fill_color;
    private String profile_image_url;
    private boolean is_translator;
    private int listed_count;


    public void setId(String id) {
        this.id = id;
    }

    public void setProfile_location(String profile_location) {
        this.profile_location = profile_location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getProfile_location() {
        return profile_location;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getId_str() {
        return id_str;
    }

    public String getUrl() {
        return url;
    }

    public boolean is_protected() {
        return _protected;
    }

    public void set_protected(boolean _protected) {
        this._protected = _protected;
    }

    public void setDefault_profile(boolean default_profile) {
        this.default_profile = default_profile;
    }

    public void setStatuses_count(int statuses_count) {
        this.statuses_count = statuses_count;
    }

    public void setProfile_background_tile(boolean profile_background_tile) {
        this.profile_background_tile = profile_background_tile;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setProfile_link_color(String profile_link_color) {
        this.profile_link_color = profile_link_color;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public void setFavourites_count(int favourites_count) {
        this.favourites_count = favourites_count;
    }

    public void setProfile_text_color(String profile_text_color) {
        this.profile_text_color = profile_text_color;
    }

    public void setContributors_enabled(boolean contributors_enabled) {
        this.contributors_enabled = contributors_enabled;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
        this.profile_sidebar_border_color = profile_sidebar_border_color;
    }

    public void setProfile_background_color(String profile_background_color) {
        this.profile_background_color = profile_background_color;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setIs_translation_enabled(boolean is_translation_enabled) {
        this.is_translation_enabled = is_translation_enabled;
    }

    public void setDefault_profile_image(boolean default_profile_image) {
        this.default_profile_image = default_profile_image;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public void setProfile_background_image_url(String profile_background_image_url) {
        this.profile_background_image_url = profile_background_image_url;
    }

    public void setProfile_background_image_url_https(String profile_background_image_url_https) {
        this.profile_background_image_url_https = profile_background_image_url_https;
    }

    public void setFollow_request_sent(String follow_request_sent) {
        this.follow_request_sent = follow_request_sent;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public void setProfile_use_background_image(boolean profile_use_background_image) {
        this.profile_use_background_image = profile_use_background_image;
    }

    public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
        this.profile_sidebar_fill_color = profile_sidebar_fill_color;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public void setIs_translator(boolean is_translator) {
        this.is_translator = is_translator;
    }

    public void setListed_count(int listed_count) {
        this.listed_count = listed_count;
    }

    public boolean isDefault_profile() {
        return default_profile;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public boolean isProfile_background_tile() {
        return profile_background_tile;
    }

    public String getLang() {
        return lang;
    }

    public String getProfile_link_color() {
        return profile_link_color;
    }

    public String getFollowing() {
        return following;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public String getProfile_text_color() {
        return profile_text_color;
    }

    public boolean isContributors_enabled() {
        return contributors_enabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getProfile_sidebar_border_color() {
        return profile_sidebar_border_color;
    }

    public String getProfile_background_color() {
        return profile_background_color;
    }

    public String getCreated_at() {
        return created_at;
    }

    public boolean isIs_translation_enabled() {
        return is_translation_enabled;
    }

    public boolean isDefault_profile_image() {
        return default_profile_image;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getProfile_background_image_url() {
        return profile_background_image_url;
    }

    public String getProfile_background_image_url_https() {
        return profile_background_image_url_https;
    }

    public String getFollow_request_sent() {
        return follow_request_sent;
    }

    public String getUtc_offset() {
        return utc_offset;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public String getNotifications() {
        return notifications;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public boolean isProfile_use_background_image() {
        return profile_use_background_image;
    }

    public String getProfile_sidebar_fill_color() {
        return profile_sidebar_fill_color;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public boolean isIs_translator() {
        return is_translator;
    }

    public int getListed_count() {
        return listed_count;
    }


    public TweetUserEntities getEntities() {
        return entities;
    }

    public void setEntities(TweetUserEntities entities) {
        this.entities = entities;
    }

}
