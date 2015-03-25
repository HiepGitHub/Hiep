package com.sss.linkboard.local.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class LoginAccount {

    private String userID;
    private String username;
    private String email;

    private static LoginAccount mInstance;

    public static final LoginAccount getInstance(Context context){
        if (mInstance == null){
            mInstance = new LoginAccount(context);
            mInstance.loadFromLocal();
        }
        return mInstance;
    }

    private Context mContext;
    private LoginAccount(Context context) {
        this.mContext = context;
    }

    private void loadFromLocal(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("LoginAccount",Context.MODE_PRIVATE);
        this.userID = sharedPreferences.getString("user_id","");
        this.email = sharedPreferences.getString("user_email","");
        this.username = sharedPreferences.getString("user_name","");
    }

    public void saveToLocal(String userID,String email,String userName){
        this.userID = userID;
        this.email = email;
        this.username = userName;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("LoginAccount",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_id", this.userID);
        editor.putString("user_email", this.email);
        editor.putString("user_name", username);
        editor.commit();
    }

    public boolean isLogged(){
        return !TextUtils.isEmpty(this.userID) && !TextUtils.isEmpty(this.email) && !TextUtils.isEmpty(this.username);
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
