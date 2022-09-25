package com.rifara.siklushidup.score_keeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rifara.siklushidup.R;

public class MainActivityScoreKeeper extends AppCompatActivity {

    private static final String STATE_SCORE1 = "STATE_SCORE1";
    private static final String STATE_SCORE2 = "STATE_SCORE2";
    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_score_keeper);

        mScoreText1 = (TextView) findViewById(R.id.score_1);
        mScoreText2 = (TextView) findViewById(R.id.score_2);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void showNight() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public void showDay() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE1, mScore1);
        outState.putInt(STATE_SCORE2, mScore2);
        super.onSaveInstanceState(outState);
    }

    @SuppressLint("NonConstantResourceId")
    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decrease_team1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decrease_team2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increase_team1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increase_team2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.night_mode:
                showNight();
                break;

            case R.id.day_mode:
                showDay();
                break;
        }
    }

}