package org.instorm.teamtoyforandroid;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity{
	
	private static final String TAG = "MainActivity";
	
	private ViewPager vpFragmentContainer;
	private Button btnTodo;
	private Button btnTeamNews;
	private Button btnNotifications;
	private Button btnTeamMembers;
	private LinearLayout llSlidingMenus;
	private LinearLayout llMainView;
	private static int MOVE = 0;
	private static int WINDOW_WIDTH = 0;
	private static int SPEED = 300; // complete the anim in 1s
	private static int TIMES = 40; // update 100 times/s
	private boolean hasMeasured = false;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0){
				Bundle data = msg.getData();
				int move = data.getInt("MOVE");
				moveMainView(move);
			}
			super.handleMessage(msg);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vpFragmentContainer = (ViewPager) findViewById(R.id.vp_fragment_container);
		setFragmentContainerAdapter(vpFragmentContainer);
		
		btnTodo = (Button) findViewById(R.id.btn_todo);
		btnTodo.setOnClickListener(new MenuClickListener(vpFragmentContainer, 0));
		
		btnTeamNews = (Button) findViewById(R.id.btn_team_news);
		btnTeamNews.setOnClickListener(new MenuClickListener(vpFragmentContainer, 1));
		
		btnNotifications = (Button) findViewById(R.id.btn_notifications);
		btnNotifications.setOnClickListener(new MenuClickListener(vpFragmentContainer, 2));
		
		btnTeamMembers = (Button) findViewById(R.id.btn_team_members);
		btnTeamMembers.setOnClickListener(new MenuClickListener(vpFragmentContainer, 3));
		
		llSlidingMenus = (LinearLayout) findViewById(R.id.ll_sliding_menus);
		
		llMainView = (LinearLayout) findViewById(R.id.ll_main_view);
		
		getMOVE();
	}
	
	private void getMOVE() {
        ViewTreeObserver viewTreeObserver = llMainView.getViewTreeObserver();
        // 获取控件宽度
        viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (!hasMeasured) {
                	WINDOW_WIDTH = getWindowManager().getDefaultDisplay()
                            .getWidth();
//                	RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) llMainView.getLayoutParams();
//                	layoutParams.width = WINDOW_WIDTH;
//                	llMainView.setLayoutParams(layoutParams);
                    MOVE = llSlidingMenus.getWidth();
                    Log.v(TAG, "MOVE=" + MOVE + "width="
                            + WINDOW_WIDTH);
                    hasMeasured = true;
                }
                return true;
            }
        });
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_MENU){
			new AsynMove().execute(SPEED);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	class AsynMove extends AsyncTask<Integer, Integer, Void> {

		@Override
		protected Void doInBackground(Integer... params) {
			int times = 0;
			int sleep = SPEED / TIMES;
			int a = MOVE % TIMES;
			if(a == 0){
				times = TIMES;
			} else {
				times = TIMES + 1;
			}
			int move = MOVE / TIMES;
			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) llMainView.getLayoutParams();
			if(layoutParams.leftMargin != 0){
				move = -move;
			}
			for(int i = 0; i < times; i++){
				try {
					Message msg = Message.obtain();
					msg.what = 0;
					Bundle data = new Bundle();
					data.putInt("MOVE", move);
					msg.setData(data);
					handler.sendMessage(msg);
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}
	
	private void moveMainView(int move){
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) llMainView.getLayoutParams();
		if(move > 0){
			layoutParams.leftMargin = Math.min(layoutParams.leftMargin + move, MOVE);
		} else {
			layoutParams.leftMargin = Math.max(layoutParams.leftMargin + move, 0);
		}
		layoutParams.rightMargin = -layoutParams.leftMargin;
		llMainView.setLayoutParams(layoutParams);
	}
	
	private void setFragmentContainerAdapter(ViewPager vpFragmentContainer){
		ArrayList<Fragment> fragments = new ArrayList<Fragment>();
		TodoFragment fgTodo = new TodoFragment();
		TeamNewsFragment fgTeamNews = new TeamNewsFragment();
		NotificationsFragment fgNotifications = new NotificationsFragment();
		TeamMembersFragment fgTeamMembers = new TeamMembersFragment();
		fragments.add(fgTodo);
		fragments.add(fgTeamNews);
		fragments.add(fgNotifications);
		fragments.add(fgTeamMembers);
		FragmentContainerAdapter fca = new FragmentContainerAdapter(getSupportFragmentManager(), fragments);
		vpFragmentContainer.setAdapter(fca);
		vpFragmentContainer.setCurrentItem(0);
	}
	
	private class MenuClickListener implements OnClickListener{
		
		private ViewPager vp;
		private int index;
		
		public MenuClickListener(ViewPager vp, int index){
			this.vp = vp;
			this.index = index;
		}

		@Override
		public void onClick(View v) {
			vp.setCurrentItem(index);
		}
	}
	
	private void log(String msg){
		Log.i(TAG, msg);
	}
}
