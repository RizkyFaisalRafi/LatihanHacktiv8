package com.rifara.siklushidup.sesi_enam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.rifara.siklushidup.R;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        TextView nilai1TV = findViewById(R.id.data1);
        Bundle data = getIntent().getExtras(); // Mengambil extras yang dikirim tadi
        nilai1TV.setText(data.getString("namaLengkap")); // Dengan Inputan

        TextView nilai2TV = findViewById(R.id.data2);
        nilai2TV.setText(data.getString("alamat"));

        TextView nilai3TV = findViewById(R.id.data3);
        nilai3TV.setText(data.getString("jenisKelamin"));

        TextView nilai4TV = findViewById(R.id.data4);
        nilai4TV.setText(data.getString("umur"));

        TextView nilai5TV = findViewById(R.id.data5);
        nilai5TV.setText(data.getString("universitas"));

        TextView nilai6TV = findViewById(R.id.data6);
        nilai6TV.setText(data.getString("jurusan"));

        TextView nilai7TV = findViewById(R.id.data7);
        nilai7TV.setText(data.getString("datePicker"));
    }
}