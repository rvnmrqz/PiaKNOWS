package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class q10 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rdogroup;
    RadioButton rdo;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q10);
        rdogroup=(RadioGroup)findViewById(R.id.rdogroup);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {


        if(v==btn1){
            int selectedid = rdogroup.getCheckedRadioButtonId();
            rdo=(RadioButton)findViewById(selectedid);
            if(rdo.getText().toString().equals("Scale")){
                MyScore.AddScore();
            }
            Class classReturned = QuizGenerator.nextQuestion();
            if(classReturned!=null) startActivity(new Intent(getApplication(),classReturned));
            else startActivity(new Intent(getApplication(),Main3Activity.class));
            finish();
        }
        }catch (Exception e){

        }
    }
    @Override
    public void onBackPressed(){

    }
}

