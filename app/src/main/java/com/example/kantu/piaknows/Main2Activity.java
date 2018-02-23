package com.example.kantu.piaknows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DBHelper dbHelper;
    SharedPreferences sharedPreferences;
    int quizSet;

    public Main2Activity(int quizSet) {
        this.quizSet = quizSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHelper = new DBHelper(this);
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        quizSet = getIntent().getIntExtra("quizSet",1);

        String scoreSet="";
        switch (quizSet){
            case 1:
                scoreSet = dbHelper.COL_SCORE1;
                break;
            case 2:
                scoreSet = dbHelper.COL_SCORE2;
                break;
            case 3:
                scoreSet = dbHelper.COL_SCORE3;
                break;
            default:
                scoreSet = dbHelper.COL_SCORE1;
                break;
        }

        Cursor cursor = dbHelper.getSqliteData("SELECT "+scoreSet+" FROM "+dbHelper.TABLE_USER
                                                    + " WHERE "
                                                    +dbHelper.COL_USERNAME+" = '"+sharedPreferences.getString("username"," ")+"'");
        if(cursor!=null){
            cursor.moveToFirst();

            System.out.println(cursor.getInt(0));

            int myScore = cursor.getInt(0);

            Toast.makeText(this, ""+myScore, Toast.LENGTH_SHORT).show();

            //DITO MO LAGAY UNG SINASABE MONG CHANGE NG PIC
            if(myScore == 0){
                Toast.makeText(this, "No score", Toast.LENGTH_SHORT).show();
            }
            else if (myScore>=1 && myScore<=3){
                Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();

            }else if(myScore>=4 && myScore<=6)
            {
                Toast.makeText(this, "Very Good", Toast.LENGTH_SHORT).show();
            }else if(myScore>= 7 && myScore<=10){

                Toast.makeText(this, "Excellent", Toast.LENGTH_SHORT).show();

            }

        }
    }
}
