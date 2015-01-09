package com.tr.tilesliders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 12:49.
 */
public class DataSource {
    private DbHelper dbHelper;
    private SQLiteDatabase database;
    private String[] scoreColumnsToRead = {
            DbHelper.SCORE_COLUMN_NAME_MOVES,
            DbHelper.SCORE_COLUMN_NAME_TIME
    };
    private String scoreSortOrder = DbHelper.SCORE_COLUMN_NAME_MOVES + "," + DbHelper.SCORE_COLUMN_NAME_TIME;


    public DataSource(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    public void open() throws SQLiteException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public void insertScore(Score score) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.SCORE_COLUMN_NAME_MOVES, score.getMoves());
        values.put(DbHelper.SCORE_COLUMN_NAME_TIME, score.getTime());
        values.put(DbHelper.SCORE_COLUMN_NAME_DATE_ADDED, score.getDateCreated());

        database.insert(DbHelper.SCORE_TABLE_NAME, null, values);
    }

    public List<Score> getScores(int limit) {
        List<Score> scores = new ArrayList<>();

        Cursor cursor = database.query(DbHelper.SCORE_TABLE_NAME, scoreColumnsToRead, null, null, null, null, scoreSortOrder, limit + "");
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            scores.add(createScoreFromCursor(cursor));
            cursor.moveToNext();
        }

        return scores;
    }

    public void deleteAllScores() {
        database.delete(DbHelper.SCORE_TABLE_NAME, null, null);
    }

    private Score createScoreFromCursor(Cursor cursor) {
        long moves = cursor.getLong(cursor.getColumnIndex(DbHelper.SCORE_COLUMN_NAME_MOVES));
        long time = cursor.getLong(cursor.getColumnIndex(DbHelper.SCORE_COLUMN_NAME_TIME));
        return new Score(moves, time);
    }
}
