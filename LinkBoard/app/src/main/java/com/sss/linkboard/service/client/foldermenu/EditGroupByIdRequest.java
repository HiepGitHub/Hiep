package com.sss.linkboard.service.client.foldermenu;

import com.android.volley.Response;
import com.sss.linkboard.service.client.LinkBoardAPI;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class EditGroupByIdRequest extends GsonRequest<EditGroupByIdItem>{

    public static String TAG_REQUEST = EditGroupByIdRequest.class.getSimpleName();
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
    public EditGroupByIdRequest(int method, String url, Class<EditGroupByIdItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<EditGroupByIdItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }
    public EditGroupByIdRequest(Map<String, String> params, Response.Listener<EditGroupByIdItem> listener, Response.ErrorListener errorListener){
        this(Method.POST, LinkBoardAPI.EDIT_GROUP_BY_GROUP_ID_TITLE, EditGroupByIdItem.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    public static Map<String,String> buildParam(String groupID, String title){
        Map<String,String> params = new HashMap<String,String>();
        params.put("groupID",groupID);
        params.put("title",title);
        return params;
    }
}
