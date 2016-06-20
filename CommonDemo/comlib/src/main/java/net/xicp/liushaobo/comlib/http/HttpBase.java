package net.xicp.liushaobo.comlib.http;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
@SuppressWarnings("unused")
public class HttpBase {

    @SuppressWarnings("unused")
    private static final int REQ_TYPE_DEFAULT = 0x01;
    @SuppressWarnings("unused")
    private static final int REQ_TYPE_THINK_ANDROID = 0x02;
    @SuppressWarnings("unused")
    private static final int REQ_TYPE_VOLLEY = 0x04;

    private static HttpRequest defaultHttpReq = HttpRequest.getDefaultInstance();


    @SuppressWarnings("unused")
    public static HttpRequest getDefaultRequest(){

        return defaultHttpReq;
    }


}
