package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by liushaobo on 2016/6/20.
 */

@SuppressWarnings("unused")
public class HttpRequest implements Http {

    private static final int REQ_TYPE_VOLLEY = 0x01;
    private static final int REQ_TYPE_THINK_ANDROID = 0x02;

    private static final int REQ_TYPE_DEFAULT = 0x01;

    /** define custom http request instance. **/
    protected static HttpRequest Instance;

    /** define default http request instance. **/
    private static HttpRequest defaultInstance;

    public static HttpRequest getDefaultInstance() {

        if (defaultInstance == null) {
            synchronized (HttpRequest.class) {
                if (defaultInstance == null) {
                    switch (REQ_TYPE_DEFAULT){
                        case REQ_TYPE_VOLLEY:
                            defaultInstance = new HttpRequestVolleyImpl();
                            break;
                        case REQ_TYPE_THINK_ANDROID:
                            defaultInstance = new HttpRequestThinkAndroidImpl();
                            break;
                    }
                }
            }
        }
        return defaultInstance;
    }




    public void request(final Context context, final String url, final HashMap<String, String> params,
                        final onHttpListener listener) {
        request(context, Method.GET, url, params, listener);
    }

    public void request(final Context context, final int method, final String url, final HashMap<String, String> params,
                        final onHttpListener listener) {
        switch (method) {
            case Method.GET:
            default:
                get(context, url, params, listener);
                break;
            case Method.POST:
                post(context, url, params, listener);
                break;
        }

    }

    @Override
    public void get(Context context, String url, HashMap<String, String> params, onHttpListener listener) {

    }

    @Override
    public void post(Context context, String url, HashMap<String, String> params, onHttpListener listener) {

    }
}
