package com.rifara.siklushidup.background_process;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import com.rifara.siklushidup.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Asynchronous dengan Background Thread
public class MainActivityBackgroundProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_background_process);

        Button btnStart = findViewById(R.id.btn_start);
        TextView tvStatus = findViewById(R.id.tv_status);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        btnStart.setOnClickListener(v -> {
            executor.execute(() -> { // Executor
                try {
                    //simulate process compressing
                    for (int i = 0; i <= 10; i++) {
                        Thread.sleep(500);
                        int percentage = i * 10;

                        handler.post(() -> { // Handler
                            // Update UI Main Thread
                            if (percentage == 100) {
                                tvStatus.setText(R.string.task_completed);
                            } else {
                                tvStatus.setText(String.format(getString(R.string.compressing), percentage));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}