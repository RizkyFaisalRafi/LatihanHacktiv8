package com.rifara.siklushidup.intent.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.rifara.siklushidup.R;

public class MoveActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move3);

        TextView nilaiTV = findViewById(R.id.input);
        Bundle data = getIntent().getExtras(); // Mengambil extras yang dikirim tadi
        nilaiTV.setText(data.getString("namaLengkap")); // Dengan Inputan


    }
}