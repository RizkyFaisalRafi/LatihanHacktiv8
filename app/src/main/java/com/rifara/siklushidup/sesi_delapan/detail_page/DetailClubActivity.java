package com.rifara.siklushidup.sesi_delapan.detail_page;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rifara.siklushidup.R;
import com.rifara.siklushidup.sesi_delapan.class_model.Club;

public class DetailClubActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);

        ImageView imgClub = findViewById(R.id.imgClub);
        TextView tvClubName = findViewById(R.id.tvClubName);
        TextView tvClubDetail = findViewById(R.id.tvClubDetail);

        Club club = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (club != null) {
            Glide.with(this)
                    .load(club.getPhoto())
                    .into(imgClub);
            tvClubName.setText(club.getName());
            tvClubDetail.setText(club.getDetail());
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Club");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}