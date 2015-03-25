package com.sss.linkboard.service.client.foldermenu;


import android.content.Context;

import com.android.volley.Response;
import com.sss.linkboard.service.client.LinkBoardAPI;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class GetGroupByUserIDRequest extends GsonRequest<GroupByUserIDItem>{

    public static String TAG_REQUEST = GetGroupByUserIDRequest.class.getSimpleName();

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param method
     * @param url           URL of the request to make
     * @param clazz         Relevant class object, for Gson's reflection
     * @param headers       Map of request headers
     * @param params
     * @param listener
     * @param errorListener
     */
    public GetGroupByUserIDRequest(int method, String url, Class<GroupByUserIDItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<GroupByUserIDItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }
    public GetGroupByUserIDRequest(Map<String, String> params, Response.Listener<GroupByUserIDItem> listener, Response.ErrorListener errorListener) {
        this(Method.POST, LinkBoardAPI.GET_GROUP_BY_USER_ID, GroupByUserIDItem.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    public static Map<String, String> buildParam(String userID){
        Map<String,String> params = new HashMap<String, String>();
        params.put("userID", userID);
        return params;
    }

}
