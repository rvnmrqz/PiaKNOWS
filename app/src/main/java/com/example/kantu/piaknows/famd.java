package com.example.kantu.piaknows;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class famd extends AppCompatActivity {


    Button g, d, e,f , a, b;

    private SoundPool soundPool;
    private int sound_a, sound_b, sound_g, sound_d, sound_e,
            sound_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famd);

        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        g = (Button) findViewById(R.id.g);
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

        sound_g = soundPool.load(this, R.raw.gmajchord, 1);
        sound_b = soundPool.load(this, R.raw.bmcho, 1);
        sound_a = soundPool.load(this, R.raw.amajchord, 1);
        sound_d = soundPool.load(this, R.raw.dmajchord, 1);
        sound_e = soundPool.load(this, R.raw.emcho, 1);
        sound_f = soundPool.load(this, R.raw.fsharpmin, 1);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_a, 1,1,0,0,1);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_b, 1,1,0,0,1);

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_g, 1,1,0,0,1);

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

