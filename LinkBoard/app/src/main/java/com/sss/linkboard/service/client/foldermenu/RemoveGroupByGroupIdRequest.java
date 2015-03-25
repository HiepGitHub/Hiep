package com.sss.linkboard.service.client.foldermenu;

import com.android.volley.Response;
import com.sss.linkboard.service.client.LinkBoardAPI;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class RemoveGroupByGroupIdRequest extends GsonRequest<RemoveGroupByGroupIdItem> {
    public static String TAG_REQUEST = RemoveGroupByGroupIdRequest.class.getSimpleName();
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
    public RemoveGroupByGroupIdRequest(int method, String url, Class<RemoveGroupByGroupIdItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<RemoveGroupByGroupIdItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }
    public RemoveGroupByGroupIdRequest(Map<String, String> params, Response.Listener<RemoveGroupByGroupIdItem> listener, Response.ErrorListener errorListener){
        this(Method.POST, LinkBoardAPI.REMOVE_GROUP_BY_GROUP_ID, RemoveGroupByGroupIdItem.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    public static Map<String,String> buildParam(String groupID){
        Map<String,String> params = new HashMap<String,String>();
        params.put("groupID", groupID);
        return params;
    }
}
