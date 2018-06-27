package com.example.tcpservice;

import android.os.Handler;
import android.os.Message;

public class ServiceThread extends Thread {

    Handler handler;
    boolean isRun = true;

    public ServiceThread(Handler handler){
        this.handler = handler;
    }

    public void stopForever(){
        synchronized (this){
            this.isRun = false;
        }
    }

    public void run(){
        while(isRun){
            handler.sendEmptyMessage(0);
            try {
                Thread.sleep(10000);
            }catch (Exception e){}
        }
    }

}
