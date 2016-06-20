package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
public class Request {

    private static final int REQ_TYPE_DEFAULT = 0x01;
    private static final int REQ_TYPE_THINK_ANDROID = 0x02;
    private static final int REQ_TYPE_VOLLEY = 0x04;

    public static Request defaultInstance;

    /** Convenience singleton for apps using a process-wide Request instance. */
    public static Request getInstance() {

        if (defaultInstance == null) {
            synchronized (Request.class) {
                if (defaultInstance == null) {
                    defaultInstance = new Request();
                }
            }
        }
        return defaultInstance;
    }


    public interface onRequestFinishedListener {
        /**
         * 当请求成功的时候执行该方法
         *
         * @param values
         */
        public void onComplete(String values);

        /**
         * 发生异常的时候执行该方法
         *
         * @param exceptionInfo
         */
        public void onException(Object exceptionInfo);
    }
    public void request(final Context context,final String url, final HashMap<String, String> params,
                        final onRequestFinishedListener listener) {
        request("GET",context,url, params, listener, REQ_TYPE_DEFAULT);
    }

    public void request(final Context context, final String url, final HashMap<String, String> params,
                        final onRequestFinishedListener listener, final int type) {
        request("GET",context,url, params, listener, type);
    }

    public void request(final String method,final Context context,final String url, final HashMap<String, String> params,
                        final onRequestFinishedListener listener) {
        request(method,context,url, params, listener, REQ_TYPE_DEFAULT);
    }

    public void request(final String method, final Context context, final String url, final HashMap<String, String> params,
                        final onRequestFinishedListener listener, final int type) {

        switch (method) {
            case "GET":
            default:
                get(url, params, context, listener, type);
                break;
            case "POST":
                post(url, params, context, listener, type);
                break;
        }

    }

    protected void get(final String url, final HashMap<String, String> params,
                     final Context context, final onRequestFinishedListener listener, final int type){

    };

    protected void post(final String url, final HashMap<String, String> params,
                      final Context context, final onRequestFinishedListener listener, final int type){

    };

}
