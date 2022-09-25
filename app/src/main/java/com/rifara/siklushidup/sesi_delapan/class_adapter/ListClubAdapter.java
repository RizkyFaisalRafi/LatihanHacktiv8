package com.rifara.siklushidup.sesi_delapan.class_adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rifara.siklushidup.R;
import com.rifara.siklushidup.sesi_delapan.class_model.Club;

import java.util.ArrayList;

public class ListClubAdapter extends RecyclerView.Adapter<ListClubAdapter.ListViewHolder> {
    String titik = "...";

    private final ArrayList<Club> listClub;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListClubAdapter(ArrayList<Club> list) {
        this.listClub = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.club_item, parent, false);
        return new ListViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Club club = listClub.get(position);
        Glide.with(holder.itemView.getContext())
                .load(club.getPhoto())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgPhoto);
        holder.tvName.setText(club.getName());
        holder.tvDetail.setText(club.getDetail().substring(0,45) + titik);

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(listClub.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listClub.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.logo_view);
            tvName = itemView.findViewById(R.id.nama_team_view);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Club data);
    }
}
