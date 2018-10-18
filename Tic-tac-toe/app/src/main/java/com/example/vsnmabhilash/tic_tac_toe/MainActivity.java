package com.example.vsnmabhilash.tic_tac_toe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    ImageButton b[][];
    int c[][];
    int i, j;
    int count = 0;
    boolean gameOver = false;
    Button new_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = new ImageButton[4][4];
        c = new int[4][4];


        b[1][1] = (ImageButton) findViewById(R.id.b1);
        b[1][2] = (ImageButton) findViewById(R.id.b2);
        b[1][3] = (ImageButton) findViewById(R.id.b3);
        b[2][1] = (ImageButton) findViewById(R.id.b4);
        b[2][2] = (ImageButton) findViewById(R.id.b5);
        b[2][3] = (ImageButton) findViewById(R.id.b6);
        b[3][1] = (ImageButton) findViewById(R.id.b7);
        b[3][2] = (ImageButton) findViewById(R.id.b8);
        b[3][3] = (ImageButton) findViewById(R.id.b9);

        new_game = (Button) findViewById(R.id.new_game);
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=1;
                for (i = 1; i <= 3; i++) {
                    for (j = 1; j <= 3; j++)
                        c[i][j] = 2;
                }
                for(int i =1; i < 4; i++)
                {
                    for (int j = 1; j<4; j++)
                    {
                        b[i][j].setImageResource(android.R.color.transparent);
                        b[i][j].setEnabled(true);
                    }
                }
                TextView text =(TextView)findViewById(R.id.Abhitext);
                text.setText("");
            }
        });

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++)
                c[i][j] = 2;
        }

        count=1;

        setOnClick(b[1][1],1,1);
        setOnClick(b[1][2],1,2);
        setOnClick(b[1][3],1,3);
        setOnClick(b[2][1],2,1);
        setOnClick(b[2][2],2,2);
        setOnClick(b[2][3],2,3);
        setOnClick(b[3][1],3,1);
        setOnClick(b[3][2],3,2);
        setOnClick(b[3][3],3,3);
    }

    private boolean checkBoard() {
        boolean gameOver = false;
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0)
                || (c[1][3] == 0 && c[2][2] == 0 && c[3][1] == 0)
                || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0)
                || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0)
                || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0)
                || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0)) {
            TextView text =(TextView)findViewById(R.id.Abhitext);
            text.setText("Game over. Player O win!");
            gameOver = true;
            Intent i=new Intent(MainActivity.this,Win.class);
            i.putExtra("Value","O");

            startActivity(i);

        } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1)
                || (c[1][3] == 1 && c[2][2] == 1 && c[3][1] == 1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1)
                || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1)
                || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1)) {
            TextView text =(TextView)findViewById(R.id.Abhitext);
            text.setText("Game over. player X win!");
            gameOver = true;
            Intent i=new Intent(MainActivity.this,Win.class);
            i.putExtra("Value","X");
            startActivity(i);

        } else {
            boolean empty = false;
            for(i=1; i<=3; i++) {
                for(j=1; j<=3; j++) {
                    if(c[i][j]==2) {
                        empty = true;
                        break;
                    }
                }
            }
            if(!empty) {
                gameOver = true;
                TextView text =(TextView)findViewById(R.id.Abhitext);
                text.setText("Game over. It's a draw!");
                Intent i=new Intent(MainActivity.this,Draw.class);
                i.putExtra("Value","Draw");
                startActivity(i);

            }
        }
        return gameOver;

    }

    private void setOnClick(final ImageButton btn, final int i, final int j){
        btn.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOver = checkBoard();
                if (!gameOver) {
                    if (count == 1) {
                        count = 2;
                        if (b[i][j].isEnabled()) {
                            b[i][j].setEnabled(false);
                            b[i][j].setImageResource(R.drawable.x);
                            b[i][j].setScaleType(ImageView.ScaleType.FIT_XY);
                            c[i][j] = 1;
                        }

                    } else if (count == 2) {
                        count = 1;
                        b[i][j].setImageResource(R.drawable.o);
                        b[i][j].setScaleType(ImageView.ScaleType.FIT_XY);
                        b[i][j].setEnabled(false);
                        c[i][j] = 0;

                    }
                }
                checkBoard();
            }
        });
    }
}