package net.xicp.liushaobo.framedemo.entry;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;


public class StoreList implements Serializable {

	public ArrayList<Store> data = new ArrayList<Store>();

	public void Coord(Context ctx) {
		for (int i = 0; i < data.size(); i++) {
			//data.get(i).Coord(ctx);
		}
	}
}
