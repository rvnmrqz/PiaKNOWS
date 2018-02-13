package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class q1 extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rdogoup;
    RadioButton rdo;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        rdogoup = (RadioGroup) findViewById(R.id.rdogroup);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        try {
            if (v == btn1) {
                int selectedid = rdogoup.getCheckedRadioButtonId();
                rdo = (RadioButton) findViewById(selectedid);
                if (rdo.getText().toString().equals("Chords")) {
                    MyScore.AddScore();
                }
                Intent intx = new Intent(q1.this, q2.class);
                startActivity(intx);
                finish();
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onBackPressed() {

    }
}