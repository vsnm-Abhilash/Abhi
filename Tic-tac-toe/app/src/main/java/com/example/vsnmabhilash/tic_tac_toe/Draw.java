package com.example.vsnmabhilash.tic_tac_toe;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Draw extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_cond);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        String v=b.getString("Value");
        textView=(TextView)findViewById(R.id.tv2);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setText("Its a "+v);
        mediaPlayer=MediaPlayer.create(Draw.this,R.raw.bestcry);
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
