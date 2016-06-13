package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import net.xicp.liushaobo.comlib.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
public class VolleyRequest extends Request {

    private RequestQueue mRequestQueue;


    @Override
    protected void get(final String str, final HashMap<String, String> params, final Context context, final onRequestFinishedListener listener, final int type) {

        StringRequest stringRequest = new StringRequest(str,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);
                        listener.onComplete(response);
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        L.v(error);
                        listener.onException(error.getMessage());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        L.v(stringRequest.getUrl());

        L.v(stringRequest.getOriginUrl());
        VolleySingleton.staryVolley(context, stringRequest);

    }

    @Override
    protected void post(String url, final HashMap<String, String> params, final Context context, final onRequestFinishedListener listener, final int type) {

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);
                        listener.onComplete(response);
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

        L.v(stringRequest.getUrl());

        L.v(stringRequest.getOriginUrl());
        VolleySingleton.staryVolley(context, stringRequest);

    }
}
