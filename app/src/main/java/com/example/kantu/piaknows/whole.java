package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class whole extends AppCompatActivity{
    Button major, minor;

    public void lala()
    {
        major = (Button) findViewById(R.id.majorscale);
        major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd = new Intent (whole.this, wholemaj.class);
                startActivity(asd);
            }
        });
    }
    public void lele()
    {
        minor = (Button) findViewById(R.id.minorscale);
        minor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asddd = new Intent(whole.this, wholemin.class);
                startActivity(asddd);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole);
        lala();
        lele();

    }
}
