package com.rifara.siklushidup.intent.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rifara.siklushidup.R;

public class ExplicitActivity extends AppCompatActivity implements View.OnClickListener {

    // Dengan Inputan
    EditText namaLengkap1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        // Dengan Inputan
        namaLengkap1 = findViewById(R.id.namaLengkap1);

        Button moveActivityBtn = findViewById(R.id.moveActivity);
        moveActivityBtn.setOnClickListener(this);

        Button moveActivityWithDataBtn = findViewById(R.id.moveActivityWithData);
        moveActivityWithDataBtn.setOnClickListener(this);

        Button moveActivityWithDataInputBtn = findViewById(R.id.moveActivityWithDataInput2);
        moveActivityWithDataInputBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.moveActivity) {
            Toast.makeText(this, "Berpindah Halaman", Toast.LENGTH_SHORT).show();
            Intent moveIntent1 = new Intent(ExplicitActivity.this, MoveActivity1.class);
            startActivity(moveIntent1);
        }

        else if (v.getId() == R.id.moveActivityWithData) {
            Toast.makeText(this, "Berpindah Halaman Dengan Data", Toast.LENGTH_SHORT).show();
            Intent moveIntent2 = new Intent(ExplicitActivity.this, MoveActivity2.class);
            moveIntent2.putExtra("nilai", "100"); // Mengirim data ke screenn 2
            startActivity(moveIntent2);
        }

        else if (v.getId() == R.id.moveActivityWithDataInput2) {
            Toast.makeText(this, "Berpindah Halaman Dengan Data Melalui Inputan", Toast.LENGTH_SHORT).show();
            Intent moveIntent3 = new Intent(ExplicitActivity.this, MoveActivity3.class);
            moveIntent3.putExtra("namaLengkap", namaLengkap1.getText().toString()); // Dengan Inputan
            startActivity(moveIntent3);
        }
    }
}