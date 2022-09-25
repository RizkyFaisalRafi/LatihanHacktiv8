package com.rifara.siklushidup.layouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rifara.siklushidup.R;
import com.rifara.siklushidup.assignment_satu.LifeCycleActivity;
import com.rifara.siklushidup.halaman_awal.HomeActivity;

public class LayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Button linear = findViewById(R.id.linear_xml);
        linear.setOnClickListener(this);

        Button relative = findViewById(R.id.relative_xml);
        relative.setOnClickListener(this);

        Button constraint = findViewById(R.id.constraint_xml);
        constraint.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.linear_xml) {
            Intent moveIntent1 = new Intent(LayoutActivity.this, LinearLayout.class);
            startActivity(moveIntent1);
        }

        else if (v.getId() == R.id.relative_xml) {
            Intent moveIntent2 = new Intent(LayoutActivity.this, RelativeLayout.class);
            startActivity(moveIntent2);
        }

        else if (v.getId() == R.id.constraint_xml) {
            Intent moveIntent3 = new Intent(LayoutActivity.this, ConstraintLayout.class);
            startActivity(moveIntent3);
        }

    }
}