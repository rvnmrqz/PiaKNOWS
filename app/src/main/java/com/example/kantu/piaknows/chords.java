package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chords extends AppCompatActivity {

    Button pic, vid;

    public void lala() {
        pic = (Button) findViewById(R.id.pic);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asd = new Intent(chords.this, sharppicmenu.class);
                startActivity(asd);
            }
        });
    }

    public void lele() {
        vid = (Button) findViewById(R.id.vid);
        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asdd = new Intent(chords.this, sharpvidmenu.class);
                startActivity(asdd);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords);
        lala();
        lele();
    }

}
