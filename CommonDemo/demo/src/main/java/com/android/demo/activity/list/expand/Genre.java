package com.android.demo.activity.list.expand;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by liushaobo on 2018/1/15.
 */

public class Genre extends ExpandableGroup<Artist> {
    private int iconResId;

    public Genre(String title, List<Artist> items, int iconResId) {
        super(title, items);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Genre)) return false;

        Genre genre = (Genre) obj;

        return getIconResId() == genre.getIconResId();
    }

    @Override
    public int hashCode() {
        return getIconResId();
    }
}
