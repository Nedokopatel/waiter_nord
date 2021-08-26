package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import java.util.Timer;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        setTitle("Добро пожаловать");
        setSupportActionBar(findViewById(R.id.mainToolBar));
        Runnable r = new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(GreetingActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 3000);


    }
}