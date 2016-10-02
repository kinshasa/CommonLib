package com.android.client.Fragment.user;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.Toast;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;

import com.android.client.R;
import com.android.lib.fragment.QuickFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by liusp@gagc.com.cn on 2016/7/4.
 */
public class UserCenterFragment extends QuickFragment implements View.OnClickListener {

    private final String TAG = "UserCenterFragment";
    public static final int REQ_LOGIN = 1;
    private static final int REQ_REGISTER = 2;
    private static final int REQ_UPDATE_FILE = 3;
    BridgeWebView webView;

    Button button;

    int RESULT_CODE = 0;

    ValueCallback<Uri> mUploadMessage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user_center, null);
        initView();
        return mView;
    }


    protected void initView() {

        webView = (BridgeWebView) mView.findViewById(R.id.webView);

        button = (Button) mView.findViewById(R.id.button);

        button.setOnClickListener(this);

        webView.setDefaultHandler(new DefaultHandler());
        webView.setWebChromeClient(new WebChromeClient() {

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType, String capture) {
                this.openFileChooser(uploadMsg);
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType) {
                this.openFileChooser(uploadMsg);
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                pickFile();
            }
        });

        webView.loadUrl("file:///android_asset/demo.html");

        regOSInterface();
        //callJSInterface();

    }

    private Runnable r;

    public void regOSInterface() {

        //登录接口 - osOnLogin
        webView.registerHandler("osOnLogin", new BridgeHandler() {

            @Override
            public void handler(String data, final CallBackFunction function) {

            }

        });

        //注册接口 - osOnRegister
        webView.registerHandler("osOnRegister", new BridgeHandler() {

            @Override
            public void handler(String data, final CallBackFunction function) {

            }

        });

        //用户数据接口 - osOnRegister
        webView.registerHandler("osGetUserInfo", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {


            }

        });
    }

    public void callJSInterface() {


        webView.callHandler("jsUpdateUserInfo", "", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
            }
        });

        //调用JS default方法
        webView.send("default function", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void pickFile() {
        Intent chooserIntent = new Intent(Intent.ACTION_GET_CONTENT);
        chooserIntent.setType("image/*");
        startActivityForResult(chooserIntent, RESULT_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQ_LOGIN:
            case REQ_REGISTER:
                if (resultCode == Activity.RESULT_OK) {
                    //button.performClick();
                    //r.run();
                } else {
                    //登录注册失败
                }
                break;

            case REQ_UPDATE_FILE:
                if (null == mUploadMessage) {
                    return;
                }
                Uri result = intent == null || resultCode != Activity.RESULT_OK ? null : intent.getData();
                mUploadMessage.onReceiveValue(result);
                mUploadMessage = null;
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                callJSInterface();
                break;
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

}
