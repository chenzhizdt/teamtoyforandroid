package org.instorm.teamtoyforandroid;

import java.util.List;

import org.instorm.teamtoyforandroid.model.Todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TodoListAdapter extends ArrayAdapter<Todo>{
	
	private static int resource = R.layout.list_item_todo;
	
	public TodoListAdapter(Context context, List<Todo> objects) {
		super(context, resource, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Todo todo = getItem(position);
		View view = null;
		if(convertView == null){
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
			view = li.inflate(resource, null, true);
		} else {
			view = convertView;
		}
		TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
		tvContent.setText(todo.getContent());
		return view;
	}
}
