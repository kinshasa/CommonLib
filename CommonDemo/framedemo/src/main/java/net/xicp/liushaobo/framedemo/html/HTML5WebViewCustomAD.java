package net.xicp.liushaobo.framedemo.html;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;


import net.xicp.liushaobo.comlib.utils.T;

/**
 * Created by liushaobo.xicp.net on 2016/6/17.
 */

public class HTML5WebViewCustomAD extends Activity {
	private HTML5CustomWebView mWebView;
	//http://www.zttmall.com/Wapshop/Topic.aspx?TopicId=18
	private String ad_url = "http://www.baidu.com";
	private String title="百度一下你就知道";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWebView = new HTML5CustomWebView(this, HTML5WebViewCustomAD.this,title,ad_url);
		mWebView.setDownloadListener(new DownloadListener() {
			@Override
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Uri uri = Uri.parse(url);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});

		/*mWebView.registerHandler("submitFromWeb", new BridgeHandler() {
			@Override
			public void handler(String data, CallBackFunction function) {
				Log.i(TAG, "handler = submitFromWeb, data from web = " + data);
				function.onCallBack("submitFromWeb exe, response data from Java");
			}
		});*/
	          //准备javascript注入
		mWebView.addJavascriptInterface(
				new Js2JavaInterface(),"Js2JavaInterface");
		if (savedInstanceState != null) {
			mWebView.restoreState(savedInstanceState);
		} else {
			if (ad_url != null) {
				mWebView.loadUrl(ad_url);
			}
		}
		setContentView(mWebView.getLayout());
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mWebView != null) {
			mWebView.saveState(outState);
		}
	}

	@TargetApi(11)
	@Override
	protected void onResume() {
		super.onResume();
		if (mWebView != null) {
			mWebView.onResume();
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		if (mWebView != null) {
			mWebView.stopLoading();
		}
	}
	@TargetApi(11)
	@Override
	protected void onPause() {
		super.onPause();
		if (mWebView != null) {
			mWebView.onPause();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mWebView != null) {
			mWebView.doDestroy();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}
	@Override
	public void onBackPressed() {
		if (mWebView != null) {
			if(mWebView.canGoBack()){
				mWebView.goBack();
			}else{
				mWebView.releaseCustomview();
			}
		}
		super.onBackPressed();
	}
	/*	 * JavaScript注入回调

	 */
	public class Js2JavaInterface {
		private Context context;
		private String TAG = "Js2JavaInterface";
		@JavascriptInterface
		public void showProduct(String productId){
			if(productId!=null){
				//进行跳转商品详情
				T.showShort(context,"点击的商品的ID为:" + productId);
			}else {
				T.showShort(context,"商品ID为空!");
			}
		}
	}
}