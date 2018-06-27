package com.example.tcpservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.start);
        btnEnd = (Button)findViewById(R.id.end);

        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            Toast.makeText(getApplicationContext(),"Service 시작",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, TcpServer.class);
            startService(intent);
        }
        });

        btnEnd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Service 종료",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TcpServer.class);
                stopService(intent);
            }
        });
    }
}
