package org.instorm.teamtoyforandroid;

import java.util.ArrayList;
import java.util.Date;

import org.instorm.teamtoyforandroid.model.Todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TodoFragment extends Fragment{
	
	private ListView lvTodo;
	private ArrayList<Todo> todos;
	private TodoListAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_todo, container, false);
		lvTodo = (ListView) view.findViewById(R.id.lv_todo);
		todos = new ArrayList<Todo>();
		for(int i = 0; i < 20; i++){
			todos.add(new Todo(new Date(), getResources().getString(R.string.test_content) + " " + i));
		}
		adapter = new TodoListAdapter(getActivity(), todos);
		lvTodo.setAdapter(adapter);
		return view;
	}
}
