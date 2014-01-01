package org.instorm.teamtoyforandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class TouchLinearLayout extends LinearLayout{
	
	private static final String TAG = "TouchLinearLayout";
	
	public TouchLinearLayout(Context context) {
		super(context);
	}
	
	public TouchLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TouchLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		addLog("TouchLinearLayout onTouchEvent");
		return super.onTouchEvent(event);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		addLog("TouchLinearLayout dispatchTouchEvent");
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		addLog("TouchLinearLayout onInterceptTouchEvent");
		return super.onInterceptTouchEvent(ev);
	}
	
	private void addLog(String msg){
		Log.v(TAG, msg);
	}
}
