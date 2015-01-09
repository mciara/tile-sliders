package com.tr.tilesliders.database;

/**
 * Author: Maciej Ciara
 * Created: 09/01/2015 11:44.
 */
public class Score {
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

    public long getDateCreated() {
        return dateCreated;
    }
}
