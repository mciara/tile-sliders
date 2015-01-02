package com.tr.tilesliders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Author: Maciej Ciara
 * Created: 31/12/2014 15:39.
 */
public class ImageAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Integer> items;

    public ImageAdapter(Context context, List<Integer> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return Long.valueOf(getItem(position).toString());
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, parent, false);
            view.setTag(R.id.picture, view.findViewById(R.id.picture));
        }

        ImageView tile = (ImageView) view.getTag(R.id.picture);
        tile.setImageResource(items.get(position));
        return tile;
    }
}