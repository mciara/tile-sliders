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
    private List<Integer> tilesInPlace = new ArrayList<>();

    public ImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);

        tilesInPlace.add(R.drawable.tile1);
        tilesInPlace.add(R.drawable.tile2);
        tilesInPlace.add(R.drawable.tile3);
        tilesInPlace.add(R.drawable.tile4);
        tilesInPlace.add(R.drawable.tile5);
        tilesInPlace.add(R.drawable.tile6);
        tilesInPlace.add(R.drawable.tile7);
        tilesInPlace.add(R.drawable.tile8);
        tilesInPlace.add(TILE_EMPTY);

        tiles.addAll(tilesInPlace);

        Collections.shuffle(tiles, new Random(System.nanoTime()));
    }

    public int getCount() {
        return tiles.size();
    }

    public Object getItem(int position) {
        return tiles.get(position);
    }

    public void swapItems(int firstPosition, int secondPosition) {
        Collections.swap(tiles, firstPosition, secondPosition);
    }

    public boolean isGameFinished() {
        return tilesInPlace.equals(tiles);
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