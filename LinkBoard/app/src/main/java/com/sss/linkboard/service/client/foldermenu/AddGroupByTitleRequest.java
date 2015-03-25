package com.sss.linkboard.service.client.foldermenu;

import com.android.volley.Response;
import com.sss.linkboard.service.client.LinkBoardAPI;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class AddGroupByTitleRequest extends GsonRequest<GroupAddByTitleItem> {

    public static String TAG_REQUEST = AddGroupByTitleRequest.class.getSimpleName();
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
    public AddGroupByTitleRequest(int method, String url, Class<GroupAddByTitleItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<GroupAddByTitleItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public AddGroupByTitleRequest(Map<String, String> params, Response.Listener<GroupAddByTitleItem> listener, Response.ErrorListener errorListener){
        this(Method.POST, LinkBoardAPI.ADD_GROUP_BY_USER_ID_TITLE, GroupAddByTitleItem.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    public static Map<String,String> buildParam(int userID, String title){
        Map<String,String> params = new HashMap<String,String>();
        params.put("userID", userID+"");
        params.put("title", title);
        return params;
    }

}
