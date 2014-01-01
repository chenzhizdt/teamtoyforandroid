package org.instorm.teamtoyforandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class LoginActivity extends Activity {
	
	private static final String TAG = "LoginActivity";
	
	private Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
		btnLogin.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					log("Action Down");
					break;
				case MotionEvent.ACTION_MOVE:
					log("Action Move");
					break;
				case MotionEvent.ACTION_UP:
					log("Action Up");
					break;
				case MotionEvent.ACTION_CANCEL:
					log("Action Cancel");
					break;
				default: break;
				}
				return false;
			}
		});
	}
	
	private void testTouch(View v){
		v.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					log("Action Down");
					break;
				case MotionEvent.ACTION_MOVE:
					log("Action Move");
					break;
				case MotionEvent.ACTION_UP:
					log("Action Up");
					break;
				default: break;
				}
				return true;
			}
		});
	}
	
	private void log(String message){
		Log.i(TAG, message);
	}
	
}
