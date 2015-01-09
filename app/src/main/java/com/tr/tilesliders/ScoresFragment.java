package com.tr.tilesliders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tr.tilesliders.database.DataSource;
import com.tr.tilesliders.database.Score;

import java.util.List;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 14:11.
 */
public class ScoresFragment extends Fragment {

    public static final int NUMBER_OF_SCORES_TO_SHOW = 10;
    private DataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource = new DataSource(getActivity());
        dataSource.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        List<Score> scores = dataSource.getScores(NUMBER_OF_SCORES_TO_SHOW);
        ScoresAdapter scoresAdapter= new ScoresAdapter(getActivity(), scores);

        ListView listView = (ListView) view.findViewById(android.R.id.list);
        listView.setAdapter(scoresAdapter);

        return view;
    }

    @Override
    public void onPause() {
        if (dataSource != null) {
            dataSource.close();
        }

        super.onPause();
    }

    @Override
    public void onResume() {
        if (dataSource != null) {
            dataSource.open();
        }

        super.onResume();
    }

    public void resetScores() {
        dataSource.deleteAllScores();
    }
}
