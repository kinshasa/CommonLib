package net.xicp.liushaobo.comlib.http;

/**
 * Created by liushaobo.xicp.net on 2016/6/13.
 */
@SuppressWarnings("unused")
public class HttpBase {


    private static Http defaultHttpReq;


    public static Http getDefaultInstance(){

        if (defaultHttpReq == null) {
            synchronized (HttpBase.class) {
                if (defaultHttpReq == null) {
                    defaultHttpReq = HttpRequestImpl.getDefaultInstance();
                }
            }
        }
        return defaultHttpReq;
    }
    


}
