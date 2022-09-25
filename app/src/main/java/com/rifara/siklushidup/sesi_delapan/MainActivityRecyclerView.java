package com.rifara.siklushidup.sesi_delapan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.rifara.siklushidup.R;
import com.rifara.siklushidup.sesi_delapan.class_adapter.ListClubAdapter;
import com.rifara.siklushidup.sesi_delapan.class_data.ClubData;
import com.rifara.siklushidup.sesi_delapan.class_model.Club;
import com.rifara.siklushidup.sesi_delapan.detail_page.DetailClubActivity;

import java.util.ArrayList;

public class MainActivityRecyclerView extends AppCompatActivity {

    private RecyclerView rvClub;
    private final ArrayList<Club> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_view);

        rvClub = findViewById(R.id.club_list_rv);
        rvClub.setHasFixedSize(true);

        list.addAll(ClubData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        ListClubAdapter listClubAdapter = new ListClubAdapter(list);
        rvClub.setAdapter(listClubAdapter);


        listClubAdapter.setOnItemClickCallback(club -> {
//                showSelectedClub(data);
            Intent moveIntent = new Intent(MainActivityRecyclerView.this, DetailClubActivity.class);
            moveIntent.putExtra(DetailClubActivity.ITEM_EXTRA, club);
            startActivity(moveIntent);
        });
    }

}