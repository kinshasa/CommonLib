package net.xicp.liushaobo.framedemo.html;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.apkfuns.jsbridge.JSCallback;
import com.apkfuns.jsbridge.JsModule;
import com.apkfuns.jsbridge.JsReturn;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.T;
import net.xicp.liushaobo.framedemo.MainActivity;
import net.xicp.liushaobo.framedemo.R;
import net.xicp.liushaobo.framedemo.bus.CouponEvent;
import net.xicp.liushaobo.framedemo.bus.MessageEvent;
import net.xicp.liushaobo.framedemo.ui.others.CouponFragment;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static void pullrefresh(HTML5WebViewCustomAD activity,final String param, final JSCallback callback){

        L.v("12345");
        EventBus.getDefault().post(new CouponEvent(param));

    }

}
