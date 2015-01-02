package com.tr.tilesliders;

/**
 * Author: Maciej Ciara
 * Created: 02/01/2015 11:59.
 */
public class GameContoller {
    private int moves;
    private long time;
    private long startTime;
    private boolean inProgress = false;

    public void startGame() {
        inProgress = true;
        moves = 0;
        time = 0L;
        startTime = System.nanoTime();
    }

    public void endGame() {
        time = System.nanoTime() - startTime;
        inProgress = false;
    }

    public void addMove() {
        moves++;
    }

    public long getTime() {
        return time; // in ms
    }

    public int getMoves() {
        return moves;
    }

    public boolean isInProgress() {
        return inProgress;
    }
}

