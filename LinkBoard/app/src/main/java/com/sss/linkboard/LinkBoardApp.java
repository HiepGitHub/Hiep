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
import com.sss.linkboard.service.client.foldermenu.AddFolderItem;
import com.sss.linkboard.service.client.foldermenu.AddFolderRequest;
import com.sss.linkboard.service.client.foldermenu.AddGroupByTitleRequest;
import com.sss.linkboard.service.client.foldermenu.EditGroupByIdItem;
import com.sss.linkboard.service.client.foldermenu.EditGroupByIdRequest;
import com.sss.linkboard.service.client.foldermenu.GetGroupByUserIDRequest;
import com.sss.linkboard.service.client.foldermenu.GroupAddByTitleItem;
import com.sss.linkboard.service.client.foldermenu.GroupByUserIDItem;
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

        /*Map<String, String> param = GetGroupByUserIDRequest.buildParam("309");
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new GetGroupByUserIDRequest(param,new Response.Listener<GroupByUserIDItem[]>() {
            @Override
            public void onResponse(GroupByUserIDItem[] groupByUserIDItem) {
                Log.v("pickhaddotcom",groupByUserIDItem.length + "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.v("pickhaddotcomerror",volleyError.getMessage());
            }
        }));*/

       /* Map<String, String> param = AddGroupByTitleRequest.buildParam("309","Second Group");
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new AddGroupByTitleRequest(param,new Response.Listener<GroupAddByTitleItem>() {
            @Override
            public void onResponse(GroupAddByTitleItem groupAddByTitleItem) {
                Log.v("pickhaddotcom",groupAddByTitleItem.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.v("pickhaddotcomerror",volleyError.getMessage());
            }
        }));*/

        /*Map<String, String> param = EditGroupByIdRequest.buildParam("425","Second Group 3333");
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new EditGroupByIdRequest(param,new Response.Listener<EditGroupByIdItem>() {
            @Override
            public void onResponse(EditGroupByIdItem editGroupByIdItem) {
                Log.v("pickhaddotcom",editGroupByIdItem.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.v("pickhaddotcomerror",volleyError.getMessage());
            }
        }));*/

        /*Map<String, String> param = AddFolderRequest.buildParam("425", "Test Folder");
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new AddFolderRequest(param,new Response.Listener<AddFolderItem>() {
            @Override
            public void onResponse(AddFolderItem addFolderItem) {
                Log.v("pickhaddotcom",addFolderItem.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.v("pickhaddotcomerror",volleyError.getMessage());
            }
        }));*/

    }
}
