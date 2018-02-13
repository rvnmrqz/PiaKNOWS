package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class lesson extends AppCompatActivity {
    Button parts, chords, famchords, scale, song;

  /*  public void lala()
    {
        parts = (Button) findViewById(R.id.parts);
        parts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent as= new Intent(lesson.this, parts.class);
                startActivity(as);
            }
        });
    }
*/
    public void lele()
    {
        chords = (Button)findViewById(R.id.chords);
        chords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd= new Intent(lesson.this, lessonchords.class);
                startActivity(asd);
            }
        });
    }

    public void lili()
    {
        famchords = (Button) findViewById(R.id.famchords);
        famchords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asdd = new Intent(lesson.this, family.class);
                startActivity(asdd);
            }
        });
    }

    public void lolo()
    {
        scale = (Button) findViewById(R.id.scale);
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent assd = new Intent(lesson.this, lessonscale.class);
                startActivity(assd);
            }
        });
    }

    public void lulu()
    {
        song = (Button) findViewById(R.id.song);
        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asds = new Intent(lesson.this, song.class);
                startActivity(asds);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        //lala();
        lele();
        lili();
        lolo();
        lulu();


    }

}

