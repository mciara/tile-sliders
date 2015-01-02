package com.tr.tilesliders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Author: Maciej Ciara
 * Created: 02/01/2015 10:35.
 */
public class GridFragment extends Fragment {
    private GameController gameController;
    private ImageAdapter imageAdapter;

    public GridFragment() {

    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_grid_view, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        imageAdapter = new ImageAdapter(rootView.getContext(), gameController.getTiles());
        gridview.setAdapter(imageAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageAdapter adapter = (ImageAdapter) parent.getAdapter();
                if (!gameController.isInProgress()) {
                    gameController.startGame();
                }

                if (gameController.isValidTileClicked(position)) {
                    gameController.swapTileWithEmpty(position);
                    adapter.notifyDataSetChanged();
                    gameController.addMove();

                    if (gameController.isGameFinished()) {
                        gameController.endGame();
                        String text = gameController.getMoves() + " moves in " + gameController.getTime()/1000000000.0 + " seconds!";
                        Toast.makeText(rootView.getContext(), text, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return rootView;
    }
    public void refreshGrid() {
        imageAdapter.notifyDataSetChanged();
    }
}