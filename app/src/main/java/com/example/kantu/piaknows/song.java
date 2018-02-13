package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class song extends AppCompatActivity {

    Button wan, tu, tri;

    public void lala()
    {
        wan = (Button) findViewById(R.id.easy);
        wan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd = new Intent(song.this, easymenu.class);
                startActivity(asd);
            }
        });
    }
    public void lele()
    {
        tu = (Button) findViewById(R.id.medium);
        tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asdd = new Intent(song.this, mediummenu.class);
                startActivity(asdd);
            }
        });
    }
    public void lili()
    {
        tri = (Button) findViewById(R.id.hard);
        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dddd = new Intent(song.this, hardmenu.class);
                startActivity(dddd);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        lala();
        lele();
        lili();
    }
}
