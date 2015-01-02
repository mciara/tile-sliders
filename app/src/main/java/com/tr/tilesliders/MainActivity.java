package com.tr.tilesliders;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    private GameController gameController = new GameController();
    GridFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            gridFragment = new GridFragment();
            gridFragment.setGameController(gameController);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, gridFragment)
                    .commit();
        }
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

            case R.id.action_settings:
                //openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openTopScores() {

    }

    private void restartGame() {
        gameController.restartGame();
        gridFragment.refreshGrid();
    }
}
