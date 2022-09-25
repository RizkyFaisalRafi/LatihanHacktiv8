package com.rifara.siklushidup.sesi_delapan.class_data;
import com.rifara.siklushidup.R;
import com.rifara.siklushidup.sesi_delapan.class_model.Club;

import java.util.ArrayList;

public class ClubData {
    private static final String [] clubName = {
            "Arsenal",
            "Chelsea",
            "Liverpool",
            "Manchester City",
            "Manchester United",
    };

    private static final String [] clubDetail = {
            "Arsenal Football Club (dikenal pula sebagai Arsenal atau The Gunners) adalah klub sepak bola profesional Inggris yang berbasis di daerah Holloway, London",
            "Chelsea Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di Fulham, London. Chelsea didirikan pada tahun 1905 dan kini berkompetisi di Liga Utama Inggris.",
            "Liverpool Football Club (dikenal pula sebagai Liverpool atau The Reds) adalah sebuah klub sepak bola asal Inggris yang berbasis di Kota Liverpool.",
            "Manchester City Football Club (dikenal pula sebagai Man City atau The Citizens) adalah sebuah klub sepak bola profesional dari Inggris yang bermain di Liga Premier Inggris. Klub ini merupakaan klub sekota dengan Manchester United dan bermarkas di Stadion Etihad, Manchester.",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional Inggris yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Inggris. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910.",
    };

    private static final int[] clubImage = {
            R.drawable.arsenal,
            R.drawable.chelsea,
            R.drawable.liverpool,
            R.drawable.mancity,
            R.drawable.manutd,
    };

    public static ArrayList<Club> getListData() {
        ArrayList<Club> list = new ArrayList<>();
        for (int position = 0; position < clubName.length; position++) {
            Club club = new Club();
            club.setName(clubName[position]);
            club.setDetail(clubDetail[position]);
            club.setPhoto(clubImage[position]);
            list.add(club);
        }
        return list;
    }
}
