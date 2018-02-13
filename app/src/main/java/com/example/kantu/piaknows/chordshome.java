package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chordshome extends AppCompatActivity {

    Button sharp, whole;

    public void lala() {
        sharp = (Button) findViewById(R.id.sharp);
        sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd = new Intent(chordshome.this, sharppicmenu.class);
                startActivity(asd);
            }
        });
    }

    public void lele() {
        whole = (Button) findViewById(R.id.whole);
        whole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asdd = new Intent(chordshome.this, wholepicmenu.class);
                startActivity(asdd);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chordshome);
        lala();
        lele();
    }
}