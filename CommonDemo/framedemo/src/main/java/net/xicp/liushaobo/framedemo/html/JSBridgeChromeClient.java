package net.xicp.liushaobo.framedemo.html;

import android.app.Activity;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.apkfuns.jsbridge.JSBridge;

/**
 * Created by liushaobo.xicp.net on 2016/6/20.
 */
public class JSBridgeChromeClient extends WebChromeClient {

    private Activity mActivity;
    JSBridgeChromeClient(Activity activity){
        this.mActivity = activity;
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        //return super.onJsPrompt(view, url, message, defaultValue, result);
        result.confirm(JSBridge.callJsPrompt(mActivity, view, message));
        return true;
    }
}
