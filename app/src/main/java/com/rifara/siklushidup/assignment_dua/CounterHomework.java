package com.rifara.siklushidup.assignment_dua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rifara.siklushidup.R;

public class CounterHomework extends AppCompatActivity {

    int counter;
    TextView nilai;
    Button tambah;
    EditText inputTxt;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_homework);

        nilai = findViewById(R.id.result_xml2);
        tambah = findViewById(R.id.btn_count_xml2);

        inputTxt = findViewById(R.id.inputTxt_xml2);

        nilai.setText(String.valueOf(counter));
        tambah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter++;
                nilai.setText(String.valueOf(counter));
            }
        });

        // Onsave Instance State
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            nilai.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, nilai.getText().toString());
    }
}