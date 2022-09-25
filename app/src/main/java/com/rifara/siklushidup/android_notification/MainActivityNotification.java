package com.rifara.siklushidup.android_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rifara.siklushidup.R;

public class MainActivityNotification extends AppCompatActivity implements View.OnClickListener {

    private static final String CHANNEL_ID = "important_mail_channel";
    NotificationManagerCompat mNotificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notification);

        Button simpleNotif = findViewById(R.id.simple_notif);
        Button bigTextStyleNotif = findViewById(R.id.big_text_style_notif);
        Button bigPictStyleNotif = findViewById(R.id.big_pict_style_notif);
        Button inboxStyleNotif = findViewById(R.id.inbox_style_notif);
        Button actionNotif = findViewById(R.id.action_notif);

        simpleNotif.setOnClickListener(this);
        bigTextStyleNotif.setOnClickListener(this);
        bigPictStyleNotif.setOnClickListener(this);
        inboxStyleNotif.setOnClickListener(this);
        actionNotif.setOnClickListener(this);

        createNotifChannel();
        mNotificationManagerCompat = NotificationManagerCompat.from(MainActivityNotification.this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple_notif:
                createSimpleNotif("Simple Notification", "Deskripsi Simple Notification", 1);
                break;

            case R.id.big_text_style_notif:
                createBigTextStyleNotif("BigText Style Notification", "Deskripsi BigText Style Notification, Deskripsi BigText Style Notification, Deskripsi BigText Style Notification, Deskripsi BigText Style Notification", 2);
                break;

            case R.id.big_pict_style_notif:
                createBigPictStyleNotif("Big Picture Style", "Big Picture Style Deskripsi", 3);
                break;

            case R.id.inbox_style_notif:
                createInboxStyleNotif("Inbox Style", "It is used for notification includes a list of (up to 5) strings", 4);
                break;

            case R.id.action_notif:
                createActionNotif("Action Notif","Action Notif Deskripsi",5);
                break;
        }
    }


    // Simple Notification
    private void createSimpleNotif(String title, String text, int notificationId) {
        mNotificationManagerCompat.cancelAll();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hacktiv8.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.hacktiv_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        mNotificationManagerCompat.notify(notificationId, notification);

    }


    // Big Text Style Notification
    private void createBigTextStyleNotif(String title, String text, int notificationId) {
        mNotificationManagerCompat.cancelAll();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hacktiv8.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hacktiv_logo);

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle().bigText(text)
                .setBigContentTitle(null)
                .setSummaryText("BigTextStyle");

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.hacktiv_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .build();

        mNotificationManagerCompat.notify(notificationId, notification);
    }


    // Big Picture Style Notification
    private void createBigPictStyleNotif(String title, String text, int notificationId) {
        mNotificationManagerCompat.cancelAll();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hacktiv8.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hacktiv_logo);

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle()
                .bigPicture(bitmap)
                .setSummaryText("Big Picture Style is used to show large image")
                .setBigContentTitle(null)
                .bigLargeIcon(null);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.hacktiv_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .build();

        mNotificationManagerCompat.notify(notificationId, notification);
    }


    // Inbox Style Notification
    private void createInboxStyleNotif(String title, String text, int notificationId) {
        mNotificationManagerCompat.cancelAll();

        String line1 = "Hallo Apa Kabar ?";
        String line2 = "Lagi Dimana ?";
        String line3 = "Kapan Pulang ?";
        String line4 = "Sedang Apa ?";
        String line5 = "Ngopi Gaslah cuy ?";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hacktiv8.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle()
                .addLine(line1)
                .addLine(line2)
                .addLine(line3)
                .addLine(line4)
                .addLine(line5)
                .setSummaryText("Inbox Style")
                .setBigContentTitle(null);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.hacktiv_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        mNotificationManagerCompat.notify(notificationId, notification);
    }


    // Action Notification
    private void createActionNotif(String title, String text, int notificationId) {
        mNotificationManagerCompat.cancelAll();

        Intent intent = new Intent(getApplicationContext(), Receiver.class);
        intent.setAction("ACTION_CANCEL");
        intent.putExtra("id", notificationId);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Action actionDismiss =
                new NotificationCompat.Action.Builder(0, "Dismiss", pendingIntent)
                .build();

        NotificationCompat.Action actionDelete =
                new NotificationCompat.Action.Builder(0, "Delete", pendingIntent)
                .build();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.hacktiv_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("This is an example of BigTextStyle notification with action."))
                .addAction(actionDismiss)
                .addAction(actionDelete)

                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        mNotificationManagerCompat.notify(notificationId, notification);
    }

    // Notification Channel
    private void createNotifChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "important_mail_channel";
            String description = "This Channel Will Show Notif Only To You Important People";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
}