package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.StrUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
@SuppressWarnings("unused")
public class HttpRequestVolleyImpl extends HttpRequest {

    private RequestQueue mRequestQueue;

    /**
     * implements Volley http request instance.
     *
     * */
    public static HttpRequest getInstance() {

        if (Instance == null) {
            synchronized (HttpRequest.class) {
                if (Instance == null) {
                    Instance = new HttpRequestVolleyImpl();
                }
            }
        }
        return Instance;
    }

    private synchronized RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }

    public void startVolley(Context context, StringRequest stringRequest) {
        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10 * 1000, 0, 1.0f));
        getRequestQueue(context).add(stringRequest);

    }

    @Override
    public void get(final String str, final HashMap<String, String> params, final Context context, final onHttpListener listener) {

        String url = new StrUtil().encodeUrl(str,params).toString();

        StringRequest stringRequest = new StringRequest(url,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);

                        try {
                            listener.onComplete(response);
                        }catch (Exception e){
                            e.printStackTrace();
                            listener.onException(e);
                        }
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        L.v(error);
                        listener.onException(error.getMessage());
                    }
                });

        L.v(stringRequest.getUrl());
        startVolley(context, stringRequest);

    }

    @Override
    public void post(String str, final HashMap<String, String> params, final Context context, final onHttpListener listener) {

        String temp = new StrUtil().encodeUrl(str,params).toString();

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, str,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);
                        try {
                            listener.onComplete(response);
                        }catch (Exception e){
                            e.printStackTrace();
                            listener.onException(response);
                        }
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        L.v(error.getMessage());
                        listener.onException(error.getMessage());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        L.v(temp);
        startVolley(context, stringRequest);
        //VolleySingleton.startVolley(context, stringRequest);

    }
}