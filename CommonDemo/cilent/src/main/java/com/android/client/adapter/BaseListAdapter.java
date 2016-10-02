package com.android.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * listview gridview 适配器基类
 * 
 * @author zilong
 * @2015-10-21
 * @param <T>
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

	protected List<T> data = null;
	protected LayoutInflater inflater;
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public void setLayoutInflater(LayoutInflater infl) {
		inflater = infl;
	}

	public void update(List<T> list) {
		data = list;
	}

	public void update(Map<String, T> map) {
		data = new ArrayList<T>();
		data.addAll(map.values());
	}

	public List<T> getData() {
		return data;
	}

	public int getCount() {
		if (data != null && data.size() > 0) {
			return data.size();
		}
		return 0;
	}

	public T getItem(int position) {
		if (data != null && data.size() > 0) {
			return data.get(position);
		}
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
