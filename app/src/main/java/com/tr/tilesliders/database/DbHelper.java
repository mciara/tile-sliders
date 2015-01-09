package com.tr.tilesliders.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 11:01.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TileSliders.db";

    public static final String SCORE_TABLE_NAME = "score";
    public static final String SCORE_COLUMN_NAME_ID = "id";
    public static final String SCORE_COLUMN_NAME_MOVES = "moves";
    public static final String SCORE_COLUMN_NAME_TIME = "time";
    public static final String SCORE_COLUMN_NAME_DATE_ADDED = "date_added";

    private static final String SQL_CREATE_SCORE_TABLE =
            "CREATE TABLE IF NOT EXISTS" + SCORE_TABLE_NAME + " (" +
                    SCORE_COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    SCORE_COLUMN_NAME_MOVES + " INTEGER NOT NULL," +
                    SCORE_COLUMN_NAME_TIME + " INTEGER NOT NULL," +
                    SCORE_COLUMN_NAME_DATE_ADDED + " INTEGER NOT NULL," +
                    " )";

    private static final String SQL_DELETE_SCORE_TABLE = "DROP TABLE IF EXISTS " + SCORE_TABLE_NAME;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SCORE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(), String.format("Upgrading database from version %d to %d, which will destroy all old data", oldVersion, newVersion));
        db.execSQL(SQL_DELETE_SCORE_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
