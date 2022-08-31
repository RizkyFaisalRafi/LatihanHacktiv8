package com.rifara.siklushidup.assignment_satu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.rifara.siklushidup.R;

public class LifeCycleActivity extends AppCompatActivity {
    EditText komentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentar = findViewById(R.id.komentarEditText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
        // Panggil data yang disimpan dan ditampilkan
        komentar.setText(getPreferences());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
        // Save isi dari inputan
        savePreferences(komentar.getText().toString());
    }

    // Method savePreferences
    private void savePreferences(String value) {
        SharedPreferences.Editor editor = this.getSharedPreferences("Komentar", Context.MODE_PRIVATE).edit();
        editor.putString("komentar", value);
        editor.apply();
    }

    // Method GetPreferences
    String getPreferences() {
        return this.getSharedPreferences("Komentar", Context.MODE_PRIVATE).getString("komentar", null);
    }
}