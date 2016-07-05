package net.xicp.liushaobo.framedemo.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.apkfuns.jsbridge.JSBridge;

/**
 * Created by liushaobo.xicp.net on 2016/6/20.
 */
public class JSBridgeViewClient extends WebViewClient {

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        JSBridge.injectJs(view);
    }
}
