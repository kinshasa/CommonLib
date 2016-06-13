package net.xicp.liushaobo.framedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;
import java.util.Map;

public abstract class MyAdapter<T> extends BaseListAdapter<T> {

	public MyAdapter(Context ct, List<T> list) {
		// TODO Auto-generated constructor stub
		context = ct;
		setLayoutInflater(LayoutInflater.from(context));
		update(list);
	}

	public MyAdapter(Context ct, List<T> list, Object o) {
		// TODO Auto-generated constructor stub
		context = ct;
		setLayoutInflater(LayoutInflater.from(context));
		update(list);
	}

	public MyAdapter(Context ct, Map<String, T> map) {
		// TODO Auto-generated constructor stub
		context = ct;
		setLayoutInflater(LayoutInflater.from(context));
		update(map);
	}

}
