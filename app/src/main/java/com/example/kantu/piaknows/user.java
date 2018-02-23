package com.example.kantu.piaknows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class user extends AppCompatActivity {

    public Button lessons, recitals, progress, games, logouts,kwe;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public void lali()
    {
        lessons = (Button) findViewById(R.id.lesson);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent les = new Intent(user.this, lesson.class);
                startActivity(les);
            }
        });
    }

    public void lele()
    {
        recitals = (Button) findViewById(R.id.recital);
        recitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rec = new Intent(user.this, qp.class);
                startActivity(rec);
            }
        });
    }
    public void lolo()
    {
        games = (Button)findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(user.this, pianotiless.class);
                startActivity(game);
            }
        });
    }

    public void leli()
    {
        kwe = (Button)findViewById(R.id.kwez);
        kwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent prrog = new Intent(user.this, q1.class);
                //startActivity(prrog);

                QuizGenerator.startQuiz(1);
                Class classReturned = QuizGenerator.nextQuestion();
                if(classReturned!=null) startActivity(new Intent(user.this,classReturned));

            }
        });
    }
       public void lili()
    {
        progress = (Button)findViewById(R.id.progressss);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prog = new Intent(user.this, Main2Activity.class);
                startActivity(prog);
            }
        });
    }

    public void deym()
    {
        logouts = (Button)findViewById(R.id.logout);
        logouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putBoolean("logged",false);
                editor.commit();

                Intent log = new Intent(user.this, login.class);
                startActivity(log);
                finish();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        lali();
        lele();
        lili();
        leli();
        lolo();
        deym();
    }
}