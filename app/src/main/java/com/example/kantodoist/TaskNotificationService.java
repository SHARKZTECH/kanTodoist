package com.example.kantodoist;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;

import androidx.core.app.NotificationCompat;


public class TaskNotificationService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    private static final  int NOTIFICATION_ID= 5453;
    private static final String CHANNEL_ID = "TaskNotificationChannel";


    public TaskNotificationService() {
        super("TaskNotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try{
                wait(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        String text=intent.getStringExtra(EXTRA_MESSAGE);
//        showText(text);
        sendBroadcast(new Intent(this,TaskNotificationBroadcastReceiver.class).putExtra("message",text));
    }

    private void showText(String text) {
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Task Notification Channel",
                    NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle("Task is Due")
                .setContentText(text)
                .setPriority(Notification.PRIORITY_HIGH)
                .setVibrate(new long[] {Long.valueOf(0),Long.valueOf(1000)})
                .setAutoCancel(true);


        // Create an InboxStyle object
//        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
//
//        // Add the new task to the list
//        inboxStyle.addLine(text);
//
//        // Retrieve a list of all the active notifications
//        StatusBarNotification[] notifications = nm.getActiveNotifications();
//
//        // Add each notification's task to the list
//        for (StatusBarNotification notification : notifications) {
//            String content = notification.getNotification().extras.getString(NotificationCompat.EXTRA_TEXT);
//            inboxStyle.addLine(content);
//        }
//
//        // Set the notification's content to the list of tasks
//        builder.setStyle(inboxStyle);

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT|PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        nm.notify(NOTIFICATION_ID,builder.build());
    }

}