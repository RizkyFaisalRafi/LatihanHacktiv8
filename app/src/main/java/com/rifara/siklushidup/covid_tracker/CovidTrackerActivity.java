package com.rifara.siklushidup.covid_tracker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.rifara.siklushidup.databinding.ActivityCovidTrackerBinding;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidTrackerActivity extends AppCompatActivity {

    private ActivityCovidTrackerBinding binding;
    private static final String TAG = "CovidTrackerActivity";
    int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCovidTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        findCovid();

    }

    private void findCovid() {
        showLoading(true);

        Call <CovidResponse> client = ApiConfig.service().getDataCovid();
        client.enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(@NonNull Call<CovidResponse> call, @NonNull Response<CovidResponse> response) {
                showLoading(false);
                if (response.isSuccessful()) {
                    CovidResponse result = response.body();
                    assert result != null;
                    Log.d(TAG, result.toString());
                    data = result.getCases();
                    setCovidData(result);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CovidResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t);
                showLoading(true);

            }
        });
    }

    private void setCovidData(CovidResponse covidData) {
        binding.countCases.setText(String.valueOf(covidData.getCases()));
        binding.countRecoverCovid.setText(String.valueOf(covidData.getRecovered()));
        binding.countDeathCovid.setText(String.valueOf(covidData.getDeaths()));
    }

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }
}