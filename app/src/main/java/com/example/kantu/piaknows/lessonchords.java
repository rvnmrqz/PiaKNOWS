package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lessonchords extends AppCompatActivity {

    Button naks;

    public void deym()
    {
        naks = (Button)findViewById(R.id.neks);
        naks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(lessonchords.this, chordshome.class);
                startActivity(log);
                finish();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonchords);
        deym();
    }
}
