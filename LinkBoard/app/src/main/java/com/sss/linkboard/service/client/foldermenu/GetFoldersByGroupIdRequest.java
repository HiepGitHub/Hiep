package com.sss.linkboard.service.client.foldermenu;

import com.android.volley.Response;
import com.sss.linkboard.service.client.LinkBoardAPI;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class GetFoldersByGroupIdRequest extends GsonRequest<GetFoldersByGroupIDItem>{
    public static String TAG_REQUEST = GetFoldersByGroupIdRequest.class.getSimpleName();
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
    public GetFoldersByGroupIdRequest(int method, String url, Class<GetFoldersByGroupIDItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<GetFoldersByGroupIDItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public GetFoldersByGroupIdRequest(Map<String, String> params, Response.Listener<GetFoldersByGroupIDItem> listener, Response.ErrorListener errorListener){
        this(Method.POST, LinkBoardAPI.GET_FOLDER_BY_GROUP_ID, GetFoldersByGroupIDItem.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    public static Map<String,String> buildParam(String groupID){
        Map<String,String> params = new HashMap<String,String>();
        params.put("groupID", groupID);
        return params;
    }
}
