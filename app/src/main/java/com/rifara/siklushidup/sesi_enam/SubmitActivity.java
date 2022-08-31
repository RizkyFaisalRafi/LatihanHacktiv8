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
        Bundle data2 = getIntent().getExtras();
        nilai2TV.setText(data2.getString("alamat"));

        TextView nilai3TV = findViewById(R.id.data3);
        Bundle data3 = getIntent().getExtras();
        nilai3TV.setText(data3.getString("jenisKelamin"));

        TextView nilai4TV = findViewById(R.id.data4);
        Bundle data4 = getIntent().getExtras();
        nilai4TV.setText(data4.getString("umur"));

        TextView nilai5TV = findViewById(R.id.data5);
        Bundle data5 = getIntent().getExtras();
        nilai5TV.setText(data5.getString("universitas"));

        TextView nilai6TV = findViewById(R.id.data6);
        Bundle data6 = getIntent().getExtras();
        nilai6TV.setText(data6.getString("jurusan"));

        TextView nilai7TV = findViewById(R.id.tv_dateresult);
        Bundle data7 = getIntent().getExtras();
        nilai7TV.setText(data7.getString("datePicker"));
    }
}