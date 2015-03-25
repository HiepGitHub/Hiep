package com.sss.linkboard.local.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingSocialSearchModel {
    private String twitterAll;
    private String twitterAny;
    private String twitterNone;
    private String twitterExact;
    private String twitterHashtags;
    private String twitterTo;
    private String twitterFrom;
    private String twitterMention;
    private String twitterType;

    private static SettingSocialSearchModel mInstance;

    public static final SettingSocialSearchModel getInstance(Context context){
        if (mInstance == null){
            mInstance = new SettingSocialSearchModel(context);
            mInstance.loadFromLocal();
        }
        return mInstance;
    }

    private Context mContext;
    private SettingSocialSearchModel(Context context) {
        this.mContext = context;
    }

    private void loadFromLocal(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("SettingWebSearchModel",Context.MODE_PRIVATE);
        this.twitterAll = sharedPreferences.getString("social_search_twitter_all","");
        this.twitterAny = sharedPreferences.getString("social_search_twitter_any","");
        this.twitterNone = sharedPreferences.getString("social_search_twitter_non","");
        this.twitterExact = sharedPreferences.getString("social_search_twitter_exact","");
        this.twitterHashtags = sharedPreferences.getString("social_search_twitter_hashtags","");
        this.twitterTo = sharedPreferences.getString("social_search_twitter_to","");
        this.twitterFrom = sharedPreferences.getString("social_search_twitter_from","");
        this.twitterMention = sharedPreferences.getString("social_search_twitter_mention","");
        this.twitterType = sharedPreferences.getString("social_search_twitter_type","");
    }

    public void saveToLocal(String twitterAll,String twitterAny,String twitterNone, String twitterExact,String twitterHashtags,String twitterFrom,String twitterTo, String twitterMention, String twitterType){
        this.twitterAll = twitterAll;
        this.twitterAny = twitterAny;
        this.twitterNone = twitterNone;
        this.twitterExact = twitterExact;
        this.twitterHashtags = twitterHashtags;
        this.twitterTo = twitterTo;
        this.twitterFrom = twitterFrom;
        this.twitterMention = twitterMention;
        this.twitterType = twitterType;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("SettingWebSearchModel",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("social_search_twitter_all", this.twitterAll);
        editor.putString("social_search_twitter_any", this.twitterAny);
        editor.putString("social_search_twitter_non", this.twitterNone);
        editor.putString("social_search_twitter_exact", this.twitterExact);
        editor.putString("social_search_twitter_hashtags", this.twitterHashtags);
        editor.putString("social_search_twitter_to", this.twitterTo);
        editor.putString("social_search_twitter_from", this.twitterFrom);
        editor.putString("social_search_twitter_mention", this.twitterMention);
        editor.putString("social_search_twitter_type", this.twitterType);
        editor.commit();
    }

    public String getTwitterAll() {
        return twitterAll;
    }

    public void setTwitterAll(String twitterAll) {
        this.twitterAll = twitterAll;
    }

    public String getTwitterAny() {
        return twitterAny;
    }

    public void setTwitterAny(String twitterAny) {
        this.twitterAny = twitterAny;
    }

    public String getTwitterNone() {
        return twitterNone;
    }

    public void setTwitterNone(String twitterNone) {
        this.twitterNone = twitterNone;
    }

    public String getTwitterExact() {
        return twitterExact;
    }

    public void setTwitterExact(String twitterExact) {
        this.twitterExact = twitterExact;
    }

    public String getTwitterHashtags() {
        return twitterHashtags;
    }

    public void setTwitterHashtags(String twitterHashtags) {
        this.twitterHashtags = twitterHashtags;
    }

    public String getTwitterTo() {
        return twitterTo;
    }

    public void setTwitterTo(String twitterTo) {
        this.twitterTo = twitterTo;
    }

    public String getTwitterFrom() {
        return twitterFrom;
    }

    public void setTwitterFrom(String twitterFrom) {
        this.twitterFrom = twitterFrom;
    }

    public String getTwitterMention() {
        return twitterMention;
    }

    public void setTwitterMention(String twitterMention) {
        this.twitterMention = twitterMention;
    }

    public String getTwitterType() {
        return twitterType;
    }

    public void setTwitterType(String twitterType) {
        this.twitterType = twitterType;
    }
}
