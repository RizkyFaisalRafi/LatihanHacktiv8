package com.rifara.siklushidup.halaman_awal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rifara.siklushidup.assignment_dua.CounterHomework;
import com.rifara.siklushidup.assignment_satu.LifeCycleActivity;
import com.rifara.siklushidup.R;
import com.rifara.siklushidup.intent.explicit.ExplicitActivity;
import com.rifara.siklushidup.intent.implicit.ImplicitActivity;
import com.rifara.siklushidup.sesi_enam.FormAssignment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);

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

    }
}