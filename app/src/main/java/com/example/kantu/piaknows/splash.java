package com.example.kantu.piaknows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;


public class splash extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //to make it fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);


        new Handler().postDelayed(new Runnable () {
            @Override
            public void run() {

                if(sharedPreferences.getString("username","").toString().length()!=0)
                {
                    //user already looged in
                    Intent intent = new Intent(getApplicationContext(), user.class);
                    startActivity(intent);

                }else{
                    // no user is logged in
                Intent homeIntent = new Intent(splash.this, login.class);
                startActivity(homeIntent);
                }

                finish();


            }

        }, SPLASH_TIME_OUT);

    }
}
