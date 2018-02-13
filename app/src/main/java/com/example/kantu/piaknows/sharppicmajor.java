package com.example.kantu.piaknows;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sharppicmajor extends AppCompatActivity {

    Button a, c, d,f , g;

    private SoundPool soundPool;
    private int sound_a, sound_c, sound_d, sound_f,
            sound_g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharppicmajor);

        a = (Button) findViewById(R.id.asharp);
        c = (Button) findViewById(R.id.csharp);
        d = (Button) findViewById(R.id.dsharp);
        f = (Button) findViewById(R.id.fsharp);
        g = (Button) findViewById(R.id.gsharp);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else
        {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_a = soundPool.load(this, R.raw.asharpmajor, 1);
        sound_c = soundPool.load(this, R.raw.csharpmajor, 1);
        sound_d = soundPool.load(this, R.raw.dsharpmajor, 1);
        sound_f = soundPool.load(this, R.raw.fsharpmajor, 1);
        sound_g = soundPool.load(this, R.raw.gsharpmajor, 1);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_a, 1,1,0,0,1);

            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_c, 1,1,0,0,1);

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_d, 1,1,0,0,1);

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_f, 1,1,0,0,1);

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_g, 1,1,0,0,1);

            }
        });
    }
}