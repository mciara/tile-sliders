package com.tr.tilesliders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Author: Maciej Ciara
 * Created: 02/01/2015 10:35.
 */
public class GridFragment extends Fragment {

    public GridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grid_view, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(rootView.getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageAdapter adapter = (ImageAdapter) parent.getAdapter();

                int tileEmptyPosition = adapter.getTileEmptyPosition();
                if (position - 3 == tileEmptyPosition || position + 3 == tileEmptyPosition ||
                        (position - 1 == tileEmptyPosition && position % 3 > 0) ||
                        (position + 1 == tileEmptyPosition && position % 3 < 2)) {

                    adapter.swapItems(position, tileEmptyPosition);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        return rootView;
    }
}