package com.sss.linkboard.service.client.tweet;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by QuangPhuong on 3/23/2015.
 */
public class TweetTemp implements Parcelable {
    private String text;
    private String name;
    private String created_at;
    private String description;
    private String url;

    public TweetTemp(String text, String name, String created_at, String description, String url) {
        this.text = text;
        this.name = name;
        this.created_at = created_at;
        this.description = description;
        this.url = url;
    }

    protected TweetTemp(Parcel in) {
        text = in.readString();
        name = in.readString();
        created_at = in.readString();
        description = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeString(description);
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TweetTemp> CREATOR = new Parcelable.Creator<TweetTemp>() {
        @Override
        public TweetTemp createFromParcel(Parcel in) {
            return new TweetTemp(in);
        }

        @Override
        public TweetTemp[] newArray(int size) {
            return new TweetTemp[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
