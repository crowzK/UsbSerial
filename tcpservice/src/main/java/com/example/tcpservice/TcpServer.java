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
            switch (msg.what){
                case 0:
                    Toast.makeText(TcpServer.this, "Connected", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(TcpServer.this, "Disconnected", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }
}
