package com.example.kantodoist;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;

import androidx.core.app.NotificationCompat;


public class TaskNotificationService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    private static final  int NOTIFICATION_ID= 5453;

    public TaskNotificationService() {
        super("TaskNotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try{
                wait(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        String text=intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(String text) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle("Task is Due")
                .setContentText(text)
                .setPriority(Notification.PRIORITY_HIGH)
                .setVibrate(new long[] {Long.valueOf(0),Long.valueOf(1000)})
                .setAutoCancel(true);

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID,builder.build());
    }

}