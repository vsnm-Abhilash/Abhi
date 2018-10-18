package com.example.vsnmabhilash.tic_tac_toe;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_cond);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        String v=b.getString("Value");
        textView=(TextView)findViewById(R.id.tv);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setText("Player "+v+" Wins");
        mediaPlayer=MediaPlayer.create(Win.this,R.raw.firework);
        mediaPlayer.start();
        Thread tre = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(10000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        tre.start();
    }
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}
