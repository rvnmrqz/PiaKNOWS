package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lessonscale extends AppCompatActivity {

    Button neksss;

    public void meme()
    {
        neksss = (Button) findViewById(R.id.neks);
        neksss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wewewewewew = new Intent(lessonscale.this, scale.class);
                startActivity(wewewewewew);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonscale);
        meme();
    }
}
