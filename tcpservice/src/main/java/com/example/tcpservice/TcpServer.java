package com.example.tcpservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;


public class TcpServer extends Service {
    NotificationManager notifyManager;
    ServiceThread thread;
    Notification notify;


    public TcpServer() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        TcpServerHandler handler = new TcpServerHandler();
        thread = new ServiceThread(handler);
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        thread.stopForever();
        thread = null;
    }

    class TcpServerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
/*            Intent intent = new Intent(TcpServer.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(TcpServer.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            notify = new Notification.Builder(getApplicationContext())
                    .setContentTitle("Content Title")
                    .setContentText("Content Text")
                    .setTicker("알림!!!")
                    .setContentIntent(pendingIntent)
                    .build();

            notify.defaults = Notification.DEFAULT_SOUND;
            notify.flags = Notification.FLAG_ONLY_ALERT_ONCE;
            notify.flags = Notification.FLAG_AUTO_CANCEL;
            notifyManager.notify(777, notify);*/
            Toast.makeText(TcpServer.this, "뜻?", Toast.LENGTH_LONG).show();
        }
    }
}
