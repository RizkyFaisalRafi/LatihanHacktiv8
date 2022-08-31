package com.rifara.siklushidup.intent.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.rifara.siklushidup.R;

public class MoveActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move2);

        TextView nilaiTV = findViewById(R.id.data);
        Bundle data = getIntent().getExtras(); // Mengambil extras yang dikirim sebelumnya
        nilaiTV.setText(data.getString("nilai")); // Dengan Membawa Data
    }
}