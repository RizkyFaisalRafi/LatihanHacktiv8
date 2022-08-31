package com.rifara.siklushidup.intent.implicit;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rifara.siklushidup.R;

import java.util.Calendar;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        Button contactButton = findViewById(R.id.contact);
        contactButton.setOnClickListener(this);

        Button webPageButton = findViewById(R.id.webPage);
        webPageButton.setOnClickListener(this);

        Button email = findViewById(R.id.email);
        email.setOnClickListener(this);

        Button calender = findViewById(R.id.calendar);
        calender.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.contact) {
            Toast.makeText(this, "Menuju Halaman Kontak Telephone", Toast.LENGTH_SHORT).show();
            // Memanggil Phone Number
            Uri number = Uri.parse("tel:0895412892094");
            Intent callIntent1 = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent1);

        } else if (v.getId() == R.id.webPage) {
            Toast.makeText(this, "Menuju Halaman Web", Toast.LENGTH_SHORT).show();
            // Memanggil Web Page
            Uri webpage = Uri.parse("https://developer.android.com/training/basics/intents/sending");
            Intent callIntent2 = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(callIntent2);
        } else if (v.getId() == R.id.email) {
            Toast.makeText(this, "Menuju Halaman Gmail", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rizkyfaisalrafi123@gmail.com"}); // recipients
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi Developer Rizky Faisal Rafi");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, ini adalah percobaan mengirim email dari aplikasi android");
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment")); // File Attachment
            // You can also attach multiple items by passing an ArrayList of Uris
            startActivity(emailIntent);
        } else if (v.getId() == R.id.calendar) {
            Toast.makeText(this, "Menuju Halaman Google Calendar", Toast.LENGTH_SHORT).show();
            // Event is on December 30, 2022 -- from 7:30 AM to 10:30 AM.
            Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2022, 11, 30, 7, 30);
            Calendar endTime = Calendar.getInstance();
            endTime.set(2022, 11, 30, 10, 30);
            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
            calendarIntent.putExtra(CalendarContract.Events.TITLE, "Happy Birthday RIZKY FAISAL RAFI");
            calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Home");
            calendarIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Happy Bithday Rizky Faisal 20 Tahun");
            startActivity(calendarIntent);
        }

    }
}
