package com.sss.linkboard.service.client;

import android.content.Context;

import com.android.volley.Response;
import com.sss.linkboard.local.model.SettingWebSearchModel;
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;


public class BingRequest extends GsonRequest<Bing>{

    public static String TAG_REQUEST = BingRequest.class.getSimpleName();

    public BingRequest(Map<String, String> params, Response.Listener<Bing> listener, Response.ErrorListener errorListener) {
        this(Method.POST, LinkBoardAPI.GET_BING_API, Bing.class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

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
    public BingRequest(int method, String url, Class<Bing> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<Bing> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public static Map<String, String> buildParam(Context context, String bing_all){
        SettingWebSearchModel model = SettingWebSearchModel.getInstance(context);
        if (bing_all.equals("")){
            bing_all = model.getBingAll();
        }
        Map<String,String> params = new HashMap<String, String>();
        params.put("bing_all", bing_all);
        params.put("bing_any", model.getBingAny());
        params.put("bing_non", model.getBingNon());
        params.put("bing_exact", model.getBingExact());
        return params;
    }

    public static Map<String, String> buildParam(String bing_all,String bing_any,String bing_non,String bing_exact){
        Map<String,String> params = new HashMap<String, String>();
        params.put("bing_all", bing_all);
        params.put("bing_any", bing_any);
        params.put("bing_non", bing_non);
        params.put("bing_exact", bing_exact);
        return params;
    }
}
