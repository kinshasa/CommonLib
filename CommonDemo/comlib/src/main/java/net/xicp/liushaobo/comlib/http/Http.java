package net.xicp.liushaobo.comlib.http;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by liushaobo on 2016/6/20.
 */
public interface Http {


    void get(final Context context, final String url, final HashMap<String, String> params, final onHttpListener listener);


    void post(final Context context,final String url, final HashMap<String, String> params, final onHttpListener listener);


    interface onHttpListener {
        /**
         * 当请求成功的时候执行该方法
         *
         * @param values
         */
        void onComplete(String values);

        /**
         * 发生异常的时候执行该方法
         *
         * @param exceptionInfo
         */
        void onException(Object exceptionInfo);
    }

    /**
     * Supported request methods.
     */
    @SuppressWarnings("unused")
    interface Method {
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }
}
