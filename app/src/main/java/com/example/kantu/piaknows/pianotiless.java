package com.example.kantu.piaknows;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class pianotiless extends AppCompatActivity {

    ImageButton p11, p12, p13,
            p21, p22, p23,
            p31, p32, p33,
            p41, p42, p43,
            p51, p52, p53;

    Button play;

    TextView times, scores, best;

    Random x;

    int a, b, c, d, e;

    int frame, paw, tap, empty;

    int currentScore = 0;

    int bestScore;

    CountDownTimer timers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pianotiless);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        bestScore = preferences.getInt("High Score", 0);

        p11 = (ImageButton) findViewById(R.id.t_11);
        p12 = (ImageButton) findViewById(R.id.t_12);
        p13 = (ImageButton) findViewById(R.id.t_13);

        p21 = (ImageButton) findViewById(R.id.t_21);
        p22 = (ImageButton) findViewById(R.id.t_22);
        p23 = (ImageButton) findViewById(R.id.t_23);

        p31 = (ImageButton) findViewById(R.id.t_31);
        p32 = (ImageButton) findViewById(R.id.t_32);
        p33 = (ImageButton) findViewById(R.id.t_33);

        p41 = (ImageButton) findViewById(R.id.t_41);
        p42 = (ImageButton) findViewById(R.id.t_42);
        p43 = (ImageButton) findViewById(R.id.t_43);

        p51 = (ImageButton) findViewById(R.id.t_51);
        p52 = (ImageButton) findViewById(R.id.t_52);
        p53 = (ImageButton) findViewById(R.id.t_53);


        play = (Button) findViewById(R.id.starts);

        times = (TextView) findViewById(R.id.time);
        times.setText("SCORE: " + millisToTime(15000));

        scores = (TextView) findViewById(R.id.scoore);
        scores.setText("SCORE: " + currentScore);

        best = (TextView) findViewById(R.id.beest);
        best.setText("SCORE: " + bestScore);

        x = new Random();
        loadImages();

        timers = new CountDownTimer(15000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                times.setText("TIME: " + millisToTime(millisUntilFinished) + 1);
            }

            @Override
            public void onFinish() {
                times.setText("TIME: " + millisToTime(0));

                p31.setEnabled(false);
                p32.setEnabled(false);
                p33.setEnabled(false);

                play.setVisibility(View.VISIBLE);

                p11.setImageResource(empty);
                p12.setImageResource(empty);
                p13.setImageResource(empty);

                p21.setImageResource(empty);
                p22.setImageResource(empty);
                p23.setImageResource(empty);

                p31.setImageResource(empty);
                p32.setImageResource(empty);
                p33.setImageResource(empty);

                p41.setImageResource(empty);
                p42.setImageResource(empty);
                p43.setImageResource(empty);

                p51.setImageResource(empty);
                p52.setImageResource(empty);
                p53.setImageResource(empty);


                Toast.makeText(pianotiless.this, "GAME OVER", Toast.LENGTH_SHORT).show();

                if (currentScore > bestScore) {
                    bestScore = currentScore;
                    best.setText("Best: " + bestScore);

                    SharedPreferences preferences1 = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = preferences1.edit();
                    editor.putInt("High Score", bestScore);
                    editor.apply();
                }
            }
        };

        p31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c == 1) {
                    continues();
                } else {
                    end();
                }
            }
        });

        p32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c == 2) {
                    continues();
                } else {
                    end();
                }
            }
        });

        p33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c == 3) {
                    continues();
                } else {
                    end();
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intitgame();

            }
        });
    }

    private void continues() {

        e = d;
        setBlackMetalLocatiion(e, 5);

        d = c;
        setBlackMetalLocatiion(d, 4);

        c = b;
        setBlackMetalLocatiion(c, 3);

        b = a;
        setBlackMetalLocatiion(b, 2);

        a = x.nextInt(3) + 1;
        setBlackMetalLocatiion(a, 1);

        currentScore++;
        scores.setText("SCORE: " + currentScore);
    }

    private void intitgame() {
        p31.setEnabled(true);
        p32.setEnabled(true);
        p33.setEnabled(true);

        play.setVisibility(View.INVISIBLE);

        currentScore = 0;
        scores.setText("SCORE: " + currentScore);

        timers.start();


        d = 2;
        p42.setImageResource(paw);

        c = 2;
        p32.setImageResource(tap);

        b = x.nextInt(3) + 1;
        setBlackMetalLocatiion(b, 2);

        a = x.nextInt(3 + 1);
        setBlackMetalLocatiion(a, 1);
    }

    private void end() {
        timers.cancel();

        p31.setEnabled(false);
        p32.setEnabled(false);
        p33.setEnabled(false);

        play.setVisibility(View.VISIBLE);

        p11.setImageResource(empty);
        p12.setImageResource(empty);
        p13.setImageResource(empty);

        p21.setImageResource(empty);
        p22.setImageResource(empty);
        p23.setImageResource(empty);

        p31.setImageResource(empty);
        p32.setImageResource(empty);
        p33.setImageResource(empty);

        p41.setImageResource(empty);
        p42.setImageResource(empty);
        p43.setImageResource(empty);

        p51.setImageResource(empty);
        p52.setImageResource(empty);
        p53.setImageResource(empty);


        Toast.makeText(pianotiless.this, "Failed", Toast.LENGTH_SHORT).show();
    }

    private void setBlackMetalLocatiion(int place, int row) {
        if (row == 1) {
            p11.setImageResource(empty);
            p12.setImageResource(empty);
            p13.setImageResource(empty);

            switch (place) {
                case 1:
                    p11.setImageResource(frame);
                    break;

                case 2:
                    p12.setImageResource(frame);
                    break;

                case 3:
                    p13.setImageResource(frame);
                    break;
            }
        }

        if (row == 2) {
            p21.setImageResource(empty);
            p22.setImageResource(empty);
            p23.setImageResource(empty);

            switch (place) {
                case 1:
                    p21.setImageResource(frame);
                    break;

                case 2:
                    p22.setImageResource(frame);
                    break;

                case 3:
                    p23.setImageResource(frame);
                    break;
            }
        }
        if (row == 3) {
            p31.setImageResource(tap);
            p32.setImageResource(tap);
            p33.setImageResource(tap);

            switch (place) {
                case 1:
                    p31.setImageResource(frame);
                    break;

                case 2:
                    p32.setImageResource(frame);
                    break;

                case 3:
                    p33.setImageResource(frame);
                    break;
            }
        }

        if (row == 4) {
            p41.setImageResource(paw);
            p42.setImageResource(paw);
            p43.setImageResource(paw);

            switch (place) {
                case 1:
                    p41.setImageResource(frame);
                    break;

                case 2:
                    p42.setImageResource(frame);
                    break;

                case 3:
                    p43.setImageResource(frame);
                    break;
            }
        }
        if (row == 5) {
            p51.setImageResource(empty);
            p52.setImageResource(empty);
            p53.setImageResource(empty);

            switch (place) {
                case 1:
                    p51.setImageResource(frame);
                    break;

                case 2:
                    p52.setImageResource(frame);
                    break;

                case 3:
                    p53.setImageResource(frame);
                    break;
            }
        }
    }


    private void loadImages() {
        frame = R.drawable.frame;
        paw = R.drawable.paw;
        tap = R.drawable.tap;
        empty = R.drawable.empty;
    }

    private int millisToTime(long millis) {
        return (int) millis / 1000;
    }
}
