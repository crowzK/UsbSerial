package com.example.tcpservice;

import android.os.Handler;
import java.io.*;
import java.net.*;
import java.util.Date;

public class ServiceThread extends Thread {

    Handler handler;
    boolean isRun = true;
    int port;

    public ServiceThread(Handler handler){
        this.handler = handler;
        port = 9999;

    }

    public void stopForever(){
        synchronized (this){
            this.isRun = false;
        }
    }

    public void run(){
        try
        {
            handler.sendEmptyMessage(0);
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            handler.sendEmptyMessage(1);
            while(isRun){
                if(writer.checkError())
                {
                    isRun = false;
                    writer.close();
                    socket.close();
                    serverSocket.close();
                    break;
                }
                writer.print("this is Test\n");
                writer.flush();
                Thread.sleep(1000);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        handler.sendEmptyMessage(2);
    }

}
