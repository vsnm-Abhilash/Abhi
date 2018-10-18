package com.example.vsnmabhilash.tic_tac_toe;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Thread tre = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i =new Intent(MainPage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        tre.start();
    }

}
