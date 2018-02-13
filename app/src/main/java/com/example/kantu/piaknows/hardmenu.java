package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hardmenu extends AppCompatActivity {

    Button halp, wul;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardmenu);

        halp = (Button) findViewById(R.id.half);
        halp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wew = new Intent(hardmenu.this, halfmenu.class);
                startActivity(wew);
            }
        });


        wul = (Button) findViewById(R.id.whole);
        wul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ew = new Intent(hardmenu.this, hard.class);
                startActivity(ew);
            }
        });



    }
}
