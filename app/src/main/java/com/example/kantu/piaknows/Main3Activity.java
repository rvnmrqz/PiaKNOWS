package com.example.kantu.piaknows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    TextView txt,txt1;
    Button btn1,bb;
    DBHelper dbHelper;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbHelper = new DBHelper(this);

        btn1=(Button)findViewById(R.id.back1);
        bb=(Button)findViewById(R.id.bb);
        btn1.setOnClickListener(this);
        bb.setOnClickListener(this);
        txt=(TextView)findViewById(R.id.score);
        txt1=(TextView)findViewById(R.id.tvscore);
        txt.setText("Your score is:"+MyScore.score);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        updateMyScore(MyScore.score);

        MyScore.score=0;
    }

    private void updateMyScore(int score){
        try{
            String scoreSet="";
            switch (QuizGenerator.glb_quizSet){
                case 1:
                    scoreSet = dbHelper.COL_SCORE1;
                    break;
                case 2:
                    scoreSet = dbHelper.COL_SCORE2;
                    break;
                case 3:
                    scoreSet = dbHelper.COL_SCORE3;
                    break;
            }

            dbHelper.executeQuery("UPDATE "+dbHelper.TABLE_USER+ " SET "+scoreSet+" = "+score +" WHERE "+dbHelper.COL_USERNAME+" = '"+sharedPreferences.getString("username"," ")+"'");
            Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();

        }catch (Exception ee){
            System.out.println( "Failed to save my score: "+ee.getMessage());
        }
    }

    public void onClick(View v) {
        if(v==btn1){
            Intent in = new Intent(this,q1.class);
            startActivity(in);
            finish();
        }
        if(v==bb){
            Intent in = new Intent(this,user.class);
            startActivity(in);
            finish();
        }
    }
    @Override
    public void onBackPressed(){

    }
}
