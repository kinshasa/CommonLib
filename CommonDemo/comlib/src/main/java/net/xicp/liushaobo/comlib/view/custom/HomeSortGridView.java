package net.xicp.liushaobo.comlib.view.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

public class HomeSortGridView extends GridView {

	private boolean scroll = false;// 可滑动

	public HomeSortGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (!scroll) {
			int expandSpec = MeasureSpec.makeMeasureSpec(
					Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, expandSpec);
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}

	@Override
	public void setSelector(Drawable sel) {
		// TODO Auto-generated method stub
		super.setSelector(new ColorDrawable(Color.TRANSPARENT));
	}

	public boolean dispatchTouchEvent(MotionEvent ev) {
		/*
		 * if(ev.getAction() == MotionEvent.ACTION_MOVE) { return true; // }
		 */
		return super.dispatchTouchEvent(ev);
	}

}