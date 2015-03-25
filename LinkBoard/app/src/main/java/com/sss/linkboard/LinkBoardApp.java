package com.sss.linkboard;

import android.app.Application;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.linkboard.service.client.BingRequest;
import com.sss.linkboard.service.client.LoginItem;
import com.sss.linkboard.service.client.LoginRequest;
import com.sss.linkboard.service.client.SignUpItem;
import com.sss.linkboard.service.client.SignUpRequest;
import com.sss.linkboard.service.client.TweetRequest;
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.service.network.PlainTextParserError;
import com.sss.linkboard.service.network.VolleySingleton;

import java.util.Map;


public class LinkBoardApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

//        Map<String, String> param = SignUpRequest.buildParam("phamduchiep@yahoo.com","phamduchiep","123456");
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new SignUpRequest(param,new Response.Listener<SignUpItem[]>() {
//            @Override
//            public void onResponse(SignUpItem[] signUpItems) {
//                Log.v("","");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                if (volleyError instanceof PlainTextParserError){
//                    String message = ((PlainTextParserError) volleyError).getJsonResponse();
//                    Log.v("pickhaddotcom",message);
//                }
//            }
//        }));


//        Map<String, String> param = LoginRequest.buildParamEmail("phamduchiep@yahoo.com", "123456");
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new LoginRequest(param,new Response.Listener<LoginItem>() {
//            @Override
//            public void onResponse(LoginItem loginItem) {
//                Log.v("","");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                if (volleyError instanceof PlainTextParserError){
//                    String message = ((PlainTextParserError) volleyError).getJsonResponse();
//                    Log.v("pickhaddotcom",message);
//                }
//            }
//        }));


//        Map<String, String> param = TweetRequest.buildParam("mobile","","","","","","","","");
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new TweetRequest(param,new Response.Listener<Tweet[]>() {
//            @Override
//            public void onResponse(Tweet[] tweets) {
//                Log.v("pickhanddotcom",tweets.length + "");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                    Log.v("pickhaddotcom",volleyError.getMessage());
//            }
//        }));

//        Map<String, String> param = BingRequest.buildParam("mobile", "", "", "");
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new BingRequest(param,new Response.Listener<Bing>() {
//            @Override
//            public void onResponse(Bing bing) {
//                Log.v("pickhaddotcom",bing.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                    Log.v("pickhaddotcom",volleyError.getMessage());
//            }
//        }));
    }
}
