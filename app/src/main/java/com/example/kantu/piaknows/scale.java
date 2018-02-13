package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class scale extends AppCompatActivity {

    Button major, minor;

    public void lala()
    {
        major = (Button) findViewById(R.id.major);
        major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asdd = new Intent(scale.this, majorscale.class);
                startActivity(asdd);
            }
        });
    }
    public void lele()
    {
        minor = (Button) findViewById(R.id.minor);
        minor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss = new Intent(scale.this, minorscale.class);
                startActivity(ss);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        lala();
        lele();
    }
}
