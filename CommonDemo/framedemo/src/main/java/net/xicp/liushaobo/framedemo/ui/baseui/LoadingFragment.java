package net.xicp.liushaobo.framedemo.ui.baseui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.framedemo.R;

/**
 * @author liushaobo
 * BaseLoadingFragment 加载动画的framgment
 * @vg_frame_whole_page 为动画背景
 * ll_frame_base_head 为主页面head
 * ll_frame_base_body 为主页面Body
 * 
 * 1. 在派生Framgment中，首先会调用lazyLoad，ll_frame_base_head.add(HeadView)定义自身的Head内容，然后返回当前加载动画
 * 2. 通过Handler机制，启动Body页面，等数据加载完成后，在SetUI里ll_frame_base_body.add(BodyView)加载到主页里。
 * 3. 如果需要加入动画，则在SetUI里加入即可。
 * 
 */
/**
 * @author liushaobo
 *
 */
public abstract class LoadingFragment extends BaseFragment {
	
	/**
	 * MSG for initUI.
	 */
	private final int MSG_INIT_UI = 1;
	private final int MSG_INIT_LOGIC = 2;
	private final int MSG_STOP_ANIMAT = 3;
	/**
	 * defined whole page.
	 */
	private ViewGroup vg_frame_whole_page;

	/**
	 * defined head page.
	 */
	private ViewGroup vg_frame_head;

	/**
	 * defined body page.
	 */
	private ViewGroup vg_frame_body;

	/**
	 * defined load page.
	 */
	private ViewGroup vg_frame_load;

	/**
	 * defined fragment move animation.
	 */
	private Animation animat_frame_move;

	/**
	 * defined fragment load animation.
	 */
	private Animation animat_load_scale;

	/**
	 * defined fragment load imgs.
	 */
	private AnimationDrawable animat_load_imgs;
	
	/**
	 * head view in head page.
	 */
	private View v_head;
	
	/**
	 * body view in body page.
	 */
	private View v_body;
	
	/**
	 * load view in load page.
	 */
	private View v_load;
	
	/**
	 * current activity.
	 */
	protected Activity baseActivity;
	
	/**
	 * current context.
	 */
	protected Context ctx;
	
	protected LayoutInflater inflater;
	
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			try {
				switch (msg.what) {
				case MSG_INIT_UI:// 获取当前定位数据设置
					L.v("initBodyView()");
					initBodyView();
					L.v("initUIWidget()");
					initUIWidget();
					L.v("stopAnimat()");
					stopAnimat();
					break;
				case MSG_INIT_LOGIC:
					L.v("initLogic()");
					initLogic();
					L.v("setUI()");
					setUI();
					break;
				case MSG_STOP_ANIMAT:
					//animat_load_imgs.stop();
					handler.sendEmptyMessageDelayed(MSG_INIT_LOGIC, 0*1000);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	};

	@Override
	@Deprecated
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		L.v();
		if(baseActivity == null){
			L.v();
			baseActivity = activity;
		}
	}
	
	@Override
	public void onAttach(Context context) {
		// TODO Auto-generated method stub
		super.onAttach(context);
		L.v();
		if(ctx == null){
			ctx = context;
		}
		
		if(inflater == null){
			inflater = LayoutInflater.from(ctx);
		}
		//define whole page.
		if(vg_frame_whole_page == null){
			L.v("frame_base_vg");
			vg_frame_whole_page = (ViewGroup) inflater.inflate(R.layout.frame_whole_page,null);
		}
		//define body page.
		if(vg_frame_body == null && vg_frame_whole_page != null){
			L.v("ll_frame_base_body");
			vg_frame_body = (ViewGroup) vg_frame_whole_page.findViewById(R.id.vg_frame_body);
			animat_frame_move = AnimationUtils.loadAnimation(baseActivity, R.anim.baseframe_frame_move);
		}
		//define head page.
		if(vg_frame_head == null && vg_frame_whole_page != null){
			L.v("ll_frame_base_head");
			vg_frame_head = (ViewGroup) vg_frame_whole_page.findViewById(R.id.vg_frame_head);
		}
		//define load page and load page start animat.
		if(vg_frame_load == null && vg_frame_whole_page != null){
			L.v("ll_frame_base_loading");
			animat_load_scale = AnimationUtils.loadAnimation(baseActivity, R.anim.baseframe_load_scale); 
			vg_frame_load = (ViewGroup) vg_frame_whole_page.findViewById(R.id.vg_frame_load);
			setLoadView(R.layout.view_page_loading);
		}
		
	}

	@Override
	protected void lazyData() {
		// TODO Auto-generated method stub
		L.v();
		vg_frame_body.setVisibility(View.GONE);
		vg_frame_load.setVisibility(View.VISIBLE);
		//animat_load_imgs.start();
		stopAnimat();
	}
	
	@Override
	protected void lazyXml() {
		// TODO Auto-generated method stub
		L.v();
		try {
			initHeadView();
		} catch (Exception e) {
			// TODO: handle exception
		}
		handler.sendEmptyMessageDelayed(MSG_INIT_UI, 1*1000);

	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		L.v();
		if(vg_frame_whole_page == null){
			L.e("vg_frame_whole_page is null.");
		}
		ViewGroup parent = (ViewGroup)vg_frame_whole_page.getParent();
        if(parent != null) {
        	L.v("removeView");
            parent.removeView(vg_frame_whole_page);
        }
		return vg_frame_whole_page;
		
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		L.v();
		super.onStart();
	};
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		L.v();
		super.onResume();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		L.v();
	}
	
	/**
	 * 1.Init HeadPage first by setHeadView(int rid).
	 */
	protected abstract void initHeadView();

	/**
	 * @param rid 2.Init LoadPage style.
	 */
	protected void setLoadView(int rid){
		L.v();
		try {
			if(vg_frame_load != null){
				L.v("setWholeView");
				v_load = (View) inflater.inflate(rid,null);
				vg_frame_load.removeAllViews();
				vg_frame_load.addView(v_load);
				//animat_load_imgs = (AnimationDrawable)((ImageView)vg_frame_load.findViewById(R.id.iv_loading)).getDrawable();
				//animat_load_imgs.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 3.Handle to init Body view by setBodyView(int rid).
	 */
	protected abstract void initBodyView();

	/**
	 * 4. Load BodyView and hide LoadView,after load body view.
	 */
	protected void stopAnimat(){
		L.v();
		vg_frame_load.startAnimation(animat_load_scale);
		vg_frame_body.startAnimation(animat_frame_move);
		vg_frame_load.setVisibility(View.GONE);
		vg_frame_body.setVisibility(View.VISIBLE);
		handler.sendEmptyMessageDelayed(MSG_STOP_ANIMAT, 1*1000);
	}

	
	/**
	 * 5. define UIWidget used with vg_frame_head,vg_frame_body.
	 */
	protected abstract void initUIWidget();

	/**
	 * 6. define Logic and YHttpRequest.
	 */
	protected abstract void initLogic();

	/**
	 * 5. set default UI with transferd data.
	 */
	protected abstract void setUI();
	
	
	
	
	
	protected View getLoadView(){
		return vg_frame_load;
	}
	
	protected void setHeadView(int rid){
		L.v();
		try {
			if(vg_frame_head != null){
				v_head = (ViewGroup) inflater.inflate(rid,null);
				vg_frame_head.removeAllViews();
				vg_frame_head.addView(v_head);
				vg_frame_head.setVisibility(View.VISIBLE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	protected View getHeadView(){
		return vg_frame_head;
	}
	
	protected void setBodyView(int rid){
		L.v();
		try {
			if(vg_frame_body != null){
				v_body = (ViewGroup) inflater.inflate(rid,null);
				vg_frame_body.removeAllViews();
				vg_frame_body.addView(v_body);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void setBodyView(View view){
		L.v();
		try {
			if(vg_frame_body != null){
				v_body = view;
				vg_frame_body.removeAllViews();
				vg_frame_body.addView(v_body);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	protected View getBodyView(){
		return vg_frame_body;
	}

}