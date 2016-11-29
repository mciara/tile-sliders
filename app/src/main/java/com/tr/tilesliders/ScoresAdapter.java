package com.tr.tilesliders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tr.tilesliders.database.Score;

import java.util.List;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 15:30.
 */
public class ScoresAdapter extends ArrayAdapter<Score> {

    public ScoresAdapter(Context context, List<Score> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Score score = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score_list_item, parent, false);
        }

        TextView indexView = (TextView) convertView.findViewById(R.id.score_index);
        TextView movesView = (TextView) convertView.findViewById(R.id.score_moves);
        TextView timeView = (TextView) convertView.findViewById(R.id.score_time);

        indexView.setText((position + 1) + ".");
        movesView.setText(score.getMoves() + " moves");
        timeView.setText(score.getTimeInSecondsWithDecimals(2) + "s");

        return convertView;
    }
}