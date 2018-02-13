package com.example.kantu.piaknows;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class qp extends AppCompatActivity {

    Button c, d, e,f ,g, a, b, cc, dd, ff, gg, aa,ch,dh,ccc;

    private SoundPool soundPool;
    private int sound_a, sound_b, sound_c, sound_d, sound_e,sound_ccc,
            sound_f, sound_g, sound_aa, sound_cc, sound_dd, sound_ff, sound_gg,sound_ch,sound_dh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qp);

        ch = (Button) findViewById(R.id.hc);
        dh = (Button) findViewById(R.id.hd);
        a = (Button) findViewById(R.id.ha);
        b = (Button) findViewById(R.id.hb);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        aa = (Button) findViewById(R.id.aa);
        cc = (Button) findViewById(R.id.cc);
        ccc = (Button) findViewById(R.id.ccc);
        dd = (Button) findViewById(R.id.dd);
        ff = (Button) findViewById(R.id.ff);
        gg = (Button) findViewById(R.id.gg);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else
        {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_a = soundPool.load(this, R.raw.a, 1);
        sound_b = soundPool.load(this, R.raw.b, 1);
        sound_c = soundPool.load(this, R.raw.c, 1);
        sound_ch = soundPool.load(this, R.raw.ch, 1);
        sound_d = soundPool.load(this, R.raw.d, 1);
        sound_dh = soundPool.load(this, R.raw.dh, 1);
        sound_e = soundPool.load(this, R.raw.e, 1);
        sound_f = soundPool.load(this, R.raw.f, 1);
        sound_g = soundPool.load(this, R.raw.g, 1);
        sound_aa = soundPool.load(this, R.raw.aa, 1);
        sound_cc = soundPool.load(this, R.raw.cc, 1);
        sound_ccc = soundPool.load(this, R.raw.ccc, 1);
        sound_dd = soundPool.load(this, R.raw.dd, 1);
        sound_ff = soundPool.load(this, R.raw.ff, 1);
        sound_gg = soundPool.load(this, R.raw.gg, 1);

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

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_c, 1,1,0,0,1);

            }
        });

        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_ch, 1,1,0,0,1);

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_d, 1,1,0,0,1);

            }
        });

        dh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_dh, 1,1,0,0,1);

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

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_g, 1,1,0,0,1);

            }
        });

        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_aa, 1,1,0,0,1);

            }
        });

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_cc, 1,1,0,0,1);

            }
        });

        ccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_ccc, 1,1,0,0,1);

            }
        });
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_dd, 1,1,0,0,1);

            }
        });

        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_ff, 1,1,0,0,1);

            }
        });

        gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_gg, 1, 1, 0, 0, 1);

            }
        });

    }
}