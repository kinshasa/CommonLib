package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.StrUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
@SuppressWarnings("unused")
public class HttpRequestThinkAndroidImpl extends HttpRequest {

    /**
     * implements ThinkAndroid http request instance.
     *
     * */
    public static HttpRequest getInstance() {

        if ( Instance == null) {
            synchronized (HttpRequest.class) {
                if (Instance == null) {
                    Instance = new HttpRequestThinkAndroidImpl();
                }
            }
        }
        return Instance;
    }

    @Override
    public void get(final String str, final HashMap<String, String> params, final Context context, final onHttpListener listener, final int type) {

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
        VolleySingleton.startVolley(context, stringRequest);

    }

    @Override
    public void post(String str, final HashMap<String, String> params, final Context context, final onHttpListener listener, final int type) {

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
        VolleySingleton.startVolley(context, stringRequest);

    }
}