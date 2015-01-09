package com.tr.tilesliders.database;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 11:44.
 */
public class Score {
    public static final double NANO_TO_SECONDS_CONVERTION = 1000000000.0;
    private long id;
    private long moves;
    private long time;
    private long dateCreated;

    public Score(long moves, long time) {
        this.moves = moves;
        this.time = time;
        this.dateCreated = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMoves() {
        return moves;
    }

    public long getTime() {
        return time;
    }

    public double getTimeInSecondsWithDecimals(int decimals) {
        return round(time/NANO_TO_SECONDS_CONVERTION, decimals);
    }

    public long getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return moves + " (in " + getTimeInSecondsWithDecimals(2) + "s)";
    }

    public static double round(double value, int decimals) {
        if (decimals < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(decimals, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
