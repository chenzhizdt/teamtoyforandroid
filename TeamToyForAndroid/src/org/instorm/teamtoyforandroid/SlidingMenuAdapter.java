package org.instorm.teamtoyforandroid;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SlidingMenuAdapter extends ArrayAdapter<SlidingMenu>{
	
	private ArrayList<SlidingMenu> menus;
	private static int resource = R.layout.list_item_sliding_menu;
	
	public SlidingMenuAdapter(Context context, List<SlidingMenu> objects) {
		super(context, resource, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if(convertView == null){
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
			view = li.inflate(resource, null, true);
		} else {
			view = convertView;
		}
		SlidingMenu menu = getItem(position);
		TextView tvMenuName = (TextView) view.findViewById(R.id.tv_menu_name);
		tvMenuName.setText(menu.getName());
		return view;
	}
	
	@Override
	public int getCount() {
		return menus.size();
	}
	
	@Override
	public SlidingMenu getItem(int position) {
		return menus.get(position);
	}
}
