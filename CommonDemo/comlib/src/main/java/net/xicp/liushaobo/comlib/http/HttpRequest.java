package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import net.xicp.liushaobo.comlib.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushaobo.xicp.net on 2016/6/12.
 */
public class HttpRequest {


    private static final int REQ_TYPE_DEFAULT = 0x01;
    private static final int REQ_TYPE_THINK_ANDROID = 0x02;
    private static final int REQ_TYPE_VOLLEY = 0x04;

    public static HttpRequest getInstance() {

        return SingleTonHolder.instance;
    }

    public void request(final Context context,final String url, final HashMap<String, String> params,
                        final AsyncListener asyncListener) {
        request("GET",context,url, params, asyncListener, REQ_TYPE_DEFAULT);
    }

    public void request(final Context context, final String url, final HashMap<String, String> params,
                        final AsyncListener asyncListener, final int type) {
        request("GET",context,url, params, asyncListener, type);
    }

    public void request(final String method,final Context context,final String url, final HashMap<String, String> params,
                        final AsyncListener asyncListener) {
        request(method,context,url, params, asyncListener, REQ_TYPE_DEFAULT);
    }

    public void request(final String method, final Context context, final String url, final HashMap<String, String> params,
                        final AsyncListener asyncListener, final int type) {

        switch (method) {
            case "GET":
            default:
                get(url, params, context, asyncListener, type);
                break;
            case "POST":
                post(url, params, context, asyncListener, type);
                break;
        }

    }

    private void get(final String url, final HashMap<String, String> params,
                     final Context context, final AsyncListener asyncListener, final int type) {

        switch (type) {
            case REQ_TYPE_DEFAULT:
            case REQ_TYPE_VOLLEY:
                getByVolley(url, params, context, asyncListener);
                break;
            case REQ_TYPE_THINK_ANDROID:
                getByThinkAndroid();
                break;

        }

    }

    private void post(final String url, final HashMap<String, String> params,
                      final Context context, final AsyncListener asyncListener, final int type) {

        switch (type) {
            case REQ_TYPE_DEFAULT:
            case REQ_TYPE_VOLLEY:
                postByVolley(url, params, context, asyncListener);
                break;
            case REQ_TYPE_THINK_ANDROID:
                getByThinkAndroid();
                break;

        }

    }

    private void getByVolley(final String str, final HashMap<String, String> params,
                             final Context context, final AsyncListener asyncListener) {

        StringRequest stringRequest = new StringRequest(str,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);
                        try {
                            asyncListener.onComplete(response);
                        }catch (Exception e){
                            asyncListener.onException(response);
                        }
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        L.v(error);
                        asyncListener.onException(error.getMessage());
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

    private void postByVolley(final String url, final HashMap<String, String> params,
                              final Context context, final AsyncListener asyncListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        L.v(response);
                        asyncListener.onComplete(response);
                    }
                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        L.v(error.getMessage());
                        asyncListener.onException(error.getMessage());
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

    private void getByThinkAndroid() {

    }

    private static class SingleTonHolder {
        public static final HttpRequest instance = new HttpRequest();
    }
}
