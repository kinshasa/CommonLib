package net.xicp.liushaobo.framedemo.webview;

import com.apkfuns.jsbridge.JSCallback;
import com.apkfuns.jsbridge.JsModule;

import net.xicp.liushaobo.comlib.utils.log.L;
import net.xicp.liushaobo.framedemo.receiver.CouponEvent;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by pengwei on 16/5/6.
 */
public class ServiceModule implements JsModule {

    /*    参数              类型                         是否可缺省
     *    Activity          Activity或者Activity子类	    可缺省
     *    WebView	        WebView或者WebView子类	    可缺省
     *    String	        String	                    不可缺省
     *    JsCallback	    JsCallback	                可缺省
    */

    @Override
    public String getModuleName() {
        return "service";
    }
    public static void pullrefresh(LoadingWebView activity,final String param, final JSCallback callback){

        L.v("12345");
        EventBus.getDefault().post(new CouponEvent(param));

    }
    

}
