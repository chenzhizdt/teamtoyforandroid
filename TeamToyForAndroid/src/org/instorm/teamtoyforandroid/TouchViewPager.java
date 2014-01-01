package org.instorm.teamtoyforandroid;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class TouchViewPager extends ViewPager{
	
	public static final String TAG = "TouchViewPager";

	public TouchViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		addLog(TAG + " dispatchTouchEvent");
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		addLog(TAG + " onTouchEvent");
		return super.onTouchEvent(arg0);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		addLog(TAG + " onInterceptTouchEvent");
		return super.onInterceptTouchEvent(arg0);
	}
	
	private void addLog(String msg){
		Log.v(TAG, msg);
	}

}
