package com.sss.linkboard.local.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class SettingWebSearchModel {
    private String bingAll;
    private String bingAny;
    private String bingNon;
    private String bingExact;

    private static SettingWebSearchModel mInstance;

    public static final SettingWebSearchModel getInstance(Context context){
        if (mInstance == null){
            mInstance = new SettingWebSearchModel(context);
            mInstance.loadFromLocal();
        }
        return mInstance;
    }

    private Context mContext;
    private SettingWebSearchModel(Context context) {
        this.mContext = context;
    }

    private void loadFromLocal(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("SettingWebSearchModel",Context.MODE_PRIVATE);
        this.bingAll = sharedPreferences.getString("web_search_bing_all","");
        this.bingAny = sharedPreferences.getString("web_search_bing_any","");
        this.bingExact = sharedPreferences.getString("web_search_bing_exact","");
        this.bingNon = sharedPreferences.getString("web_search_bing_non","");
    }

    public void saveToLocal(String bingAll,String bingAny,String bingExact, String bingNon){
        this.bingAll = bingAll;
        this.bingAny = bingAny;
        this.bingExact = bingExact;
        this.bingNon = bingNon;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("SettingWebSearchModel",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("web_search_bing_all", this.bingAll);
        editor.putString("web_search_bing_any", this.bingAny);
        editor.putString("web_search_bing_exact", this.bingExact);
        editor.putString("web_search_bing_non", this.bingNon);
        editor.commit();
    }


    public String getBingAll() {
        return bingAll;
    }

    public void setBingAll(String bingAll) {
        this.bingAll = bingAll;
    }

    public String getBingAny() {
        return bingAny;
    }

    public void setBingAny(String bingAny) {
        this.bingAny = bingAny;
    }

    public String getBingNon() {
        return bingNon;
    }

    public void setBingNon(String bingNon) {
        this.bingNon = bingNon;
    }

    public String getBingExact() {
        return bingExact;
    }

    public void setBingExact(String bingExact) {
        this.bingExact = bingExact;
    }
}
