package com.android.lib.fragment;


import com.android.lib.utils.log.L;

public abstract class DelayFragment extends BaseFragment {

	/**
	 * whether current page is showed and data load.
	 */
	protected boolean isLoadXml = false;
	
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		
		if (getUserVisibleHint()) {
			onVisible();
		} else {
			onInvisible();
		}
	}
	
	@Override
	public boolean getUserVisibleHint() {
		// TODO Auto-generated method stub
		return super.getUserVisibleHint();
	}
	
	/**
	 * 0.Judge CurData whether data is empty or not and reset UI.
	 * You can return true to refresh once cur page is visible.
	 * @return whether need to set UI or not.
	 */
	protected abstract boolean isDataNotLoad();

	/**
	 * 可见
	 */
	private void onVisible() {
		L.v();
		if(!isLoadXml){
			//load xml and data.
			isLoadXml = true;
			lazyXml();
		}else{
			if(isDataNotLoad()){
				//if data null, need to reload data.
				lazyData();
			}
		}
		
	}

	/**
	 * 不可见
	 */
	private void onInvisible() {
		L.v();
	}

	/**
	 * when fragment is visible,need to read body xml.
	 * frament入口
	 */
	
	protected abstract void lazyXml();
	
	/**
	 * when fragment is visible,read data to update UI.
	 * frament入口
	 */
	protected abstract void lazyData();


}