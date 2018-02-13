package com.example.kantu.piaknows;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class famc extends AppCompatActivity {


    Button c, d, e,f , a, g;

    private SoundPool soundPool;
    private int sound_a, sound_g, sound_c, sound_d, sound_e,
            sound_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famc);

        a = (Button) findViewById(R.id.a);
        g = (Button) findViewById(R.id.g);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else
        {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_a = soundPool.load(this, R.raw.amcho, 1);
        sound_c = soundPool.load(this, R.raw.cmajchord, 1);
        sound_d = soundPool.load(this, R.raw.dmcho, 1);
        sound_e = soundPool.load(this, R.raw.emcho, 1);
        sound_f = soundPool.load(this, R.raw.fmajchord, 1);
        sound_g = soundPool.load(this, R.raw.gmajchord, 1);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_a, 1,1,0,0,1);

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_g, 1,1,0,0,1);

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

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_e, 1,1,0,0,1);

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_f, 1,1,0,0,1);

            }
        });


    }
}