package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mediummenu extends AppCompatActivity {

    Button halp, wul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediummenu);

        halp = (Button) findViewById(R.id.half);
        halp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wew = new Intent(mediummenu.this, MainActivity.class);
                startActivity(wew);
            }
        });


        wul = (Button) findViewById(R.id.whole);
        wul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ew = new Intent(mediummenu.this, medium.class);
                startActivity(ew);
            }
        });
    }
}
