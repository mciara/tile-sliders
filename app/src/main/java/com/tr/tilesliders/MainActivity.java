package com.tr.tilesliders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedHashSet;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    public static final String GAME_IN_PROGRESS = "gameInProgress";
    public static final String GAME_START_TIME = "gameStartTime";
    public static final String GAME_MOVES = "gameMoves";
    public static final String GAME_TILES = "gameTiles";
    private GameController gameController = new GameController();
    private GridFragment gridFragment;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restoreGameState();

        gridFragment = new GridFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, gridFragment)
                .commit();
        gridFragment.setGameController(gameController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_start_game:
                restartGame();
                return true;

            case R.id.action_show_top_scores:
                openTopScores();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openTopScores() {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);

    }

    private void restartGame() {
        gameController.restartGame();
        gridFragment.refreshGrid();
    }

    protected void onPause() {
        super.onPause();

        sharedPreferences.edit()
                .putBoolean(GAME_IN_PROGRESS, gameController.isInProgress())
                .putLong(GAME_START_TIME, gameController.getStartTime())
                .putInt(GAME_MOVES, gameController.getMoves())
                .putString(GAME_TILES, gameController.getTilesAsString())
                .commit();
    }

    private void restoreGameState() {
        sharedPreferences = getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
        Map<String, ?> preferences = sharedPreferences.getAll();

        if (preferences.size() == 4) {
            gameController.setInProgress((Boolean) preferences.get(GAME_IN_PROGRESS));
            gameController.setStartTime((Long) preferences.get(GAME_START_TIME));
            gameController.setMoves((Integer) preferences.get(GAME_MOVES));
            gameController.setTiles((String) preferences.get(GAME_TILES));
        }
    }
}
