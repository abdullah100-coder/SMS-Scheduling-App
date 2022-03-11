package com.example.sms;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.start();
        Bundle extra = intent.getExtras();
        String num = extra.getString("num"), msg = extra.getString("msg");
        Toast.makeText(context, "Message Sent", Toast.LENGTH_SHORT).show();
        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(num, null, msg, null, null);


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context,"abdullah")
                        .setSmallIcon(R.drawable.sms)
                        .setContentTitle("SMS Successfully sent")
                        .setContentText(msg)
                        .setAutoCancel(true)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123, mBuilder.build());




    }
}
