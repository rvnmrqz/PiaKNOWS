package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class wholepicmenu extends AppCompatActivity {

    Button major, minor;

    public void lala() {
        major = (Button) findViewById(R.id.majorscale);
        major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent as = new Intent(wholepicmenu.this, wholepicmaj.class);
                startActivity(as);
            }
        });
    }

    public void lele() {
        minor = (Button) findViewById(R.id.minorscale);
        minor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd = new Intent(wholepicmenu.this, wholepicmin.class);
                startActivity(asd);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharppicmenu);
        lala();
        lele();
    }
}