package com.rifara.siklushidup.halaman_awal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rifara.siklushidup.android_notification.MainActivityNotification;
import com.rifara.siklushidup.assignment_dua.CounterHomework;
import com.rifara.siklushidup.assignment_satu.LifeCycleActivity;
import com.rifara.siklushidup.R;
import com.rifara.siklushidup.background_process.MainActivityBackgroundProcess;
import com.rifara.siklushidup.crud_sqlite.MainActivityCrud;
import com.rifara.siklushidup.intent.explicit.ExplicitActivity;
import com.rifara.siklushidup.intent.implicit.ImplicitActivity;
import com.rifara.siklushidup.layouting.LayoutActivity;
import com.rifara.siklushidup.score_keeper.MainActivityScoreKeeper;
import com.rifara.siklushidup.sesi_delapan.MainActivityRecyclerView;
import com.rifara.siklushidup.sesi_enam.FormAssignment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button assignment1Btn = findViewById(R.id.assignment1Btn);
        assignment1Btn.setOnClickListener(this);

        Button explicitButton = findViewById(R.id.explicitButton);
        explicitButton.setOnClickListener(this);

        Button implicitButton = findViewById(R.id.implicitButton);
        implicitButton.setOnClickListener(this);

        Button sesiEnamButton = findViewById(R.id.sesiEnamButton);
        sesiEnamButton.setOnClickListener(this);

        Button assignment2Btn = findViewById(R.id.assignment2Btn);
        assignment2Btn.setOnClickListener(this);

        Button layouting = findViewById(R.id.layout);
        layouting.setOnClickListener(this);

        Button recyclerView = findViewById(R.id.sesiDelapanButton);
        recyclerView.setOnClickListener(this);

        Button keeper = findViewById(R.id.scoreKeeper);
        keeper.setOnClickListener(this);

        Button backgProc = findViewById(R.id.backround_process);
        backgProc.setOnClickListener(this);

        Button crudSqlite = findViewById(R.id.crud_sqlite);
        crudSqlite.setOnClickListener(this);

        Button androidNotification = findViewById(R.id.android_notification);
        androidNotification.setOnClickListener(this);

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



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.assignment1Btn) {
            Intent moveIntent1 = new Intent(HomeActivity.this, LifeCycleActivity.class);
            startActivity(moveIntent1);
        }

        else if (v.getId() == R.id.explicitButton) {
            Intent moveIntent2 = new Intent(HomeActivity.this, ExplicitActivity.class);
            startActivity(moveIntent2);
        }

        else if (v.getId() == R.id.implicitButton) {
            Intent moveIntent3 = new Intent(HomeActivity.this, ImplicitActivity.class);
            startActivity(moveIntent3);
        }

        else if (v.getId() == R.id.sesiEnamButton) {
            Intent moveIntent4 = new Intent(HomeActivity.this, FormAssignment.class);
            startActivity(moveIntent4);
        }

        else if (v.getId() == R.id.assignment2Btn) {
            Intent moveIntent5 = new Intent(HomeActivity.this, CounterHomework.class);
            startActivity(moveIntent5);
        }

        else if (v.getId() == R.id.layout) {
            Intent moveIntent6 = new Intent(HomeActivity.this, LayoutActivity.class);
            startActivity(moveIntent6);
        }

        else if (v.getId() == R.id.sesiDelapanButton) {
            Intent moveIntent7 = new Intent(HomeActivity.this, MainActivityRecyclerView.class);
            startActivity(moveIntent7);
        }

        else if (v.getId() == R.id.scoreKeeper) {
            Intent moveIntent8 = new Intent(HomeActivity.this, MainActivityScoreKeeper.class);
            startActivity(moveIntent8);
        }

        else if (v.getId() == R.id.backround_process) {
            Intent moveIntent9 = new Intent(HomeActivity.this, MainActivityBackgroundProcess.class);
            startActivity(moveIntent9);
        }

        else if (v.getId() == R.id.crud_sqlite) {
            Intent moveIntent10 = new Intent(HomeActivity.this, MainActivityCrud.class);
            startActivity(moveIntent10);
        }

        else if (v.getId() == R.id.android_notification) {
            Intent moveIntent11 = new Intent(HomeActivity.this, MainActivityNotification.class);
            startActivity(moveIntent11);
        }

    }
}