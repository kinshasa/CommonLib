package com.android.client.global;

/**
 * Created by liusp@gagc.com.cn on 2016/6/27.
 */
public class URLConstant extends DevConstant{



    private final static String URL_LOCAL = "file:///android_asset/";
    private final static String URL_SERVER = "http://10.8.75.11:6070/app/";

    public final static String url = DEV_CUR == DEV_LOCAL?URL_LOCAL:URL_SERVER;

}
