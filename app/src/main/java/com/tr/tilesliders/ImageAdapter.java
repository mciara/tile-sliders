package com.tr.tilesliders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Author: Maciej Ciara
 * Created: 31/12/2014 15:39.
 */
public class ImageAdapter extends BaseAdapter {
    public static final int TILE_EMPTY = R.drawable.tile_empty;

    private LayoutInflater inflater;
    private List<Integer> tiles = new ArrayList<>();

    public ImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);

        tiles.add(R.drawable.tile1);
        tiles.add(R.drawable.tile2);
        tiles.add(R.drawable.tile3);
        tiles.add(R.drawable.tile4);
        tiles.add(TILE_EMPTY);
        tiles.add(R.drawable.tile5);
        tiles.add(R.drawable.tile6);
        tiles.add(R.drawable.tile7);
        tiles.add(R.drawable.tile8);

        long seed = System.nanoTime();
        Collections.shuffle(tiles, new Random(seed));
    }

    public int getCount() {
        return tiles.size();
    }

    public Object getItem(int position) {
        return tiles.get(position);
    }

    public Object setItem(int position, Integer item) {
        return tiles.set(position, item);
    }

    public void swapItems(int firstPosition, int secondPosition) {
        Collections.swap(tiles, firstPosition, secondPosition);
    }

    public int getTileEmptyPosition() {
        return tiles.indexOf(TILE_EMPTY);
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
        tile.setImageResource(tiles.get(position));
        return tile;
    }
}