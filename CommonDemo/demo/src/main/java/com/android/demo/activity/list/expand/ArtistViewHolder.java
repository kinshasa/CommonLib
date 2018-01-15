package com.android.demo.activity.list.expand;

import android.view.View;
import android.widget.TextView;

import com.android.demo.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by liushaobo on 2018/1/15.
 */

public class ArtistViewHolder extends ChildViewHolder {
    private TextView childTextView;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
    }
    public void setArtistName(String name) {
        childTextView.setText(name);
    }
}
