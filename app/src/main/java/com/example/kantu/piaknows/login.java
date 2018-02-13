package com.example.kantu.piaknows;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class login extends AppCompatActivity implements View.OnClickListener {


    EditText editUsername, editPassword;
    Button btnRegister, btnLogin;
    SQLiteDatabase db;

    DBHelper dbHelper;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegister = (Button) findViewById(R.id.reg);
        btnLogin = (Button) findViewById(R.id.login);

        editUsername = (EditText) findViewById(R.id.username);
        editPassword = (EditText) findViewById(R.id.password);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dbHelper = new DBHelper(this);


        //  db=openOrCreateDatabase("userDB", Context.MODE_PRIVATE,null);
    }

    public void onClick(View view) {
        if (view == btnRegister) {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        }

        if (view == btnLogin) {
            String getUsername = editUsername.getText().toString();
            String getPassword = editPassword.getText().toString();

            Cursor c = dbHelper.getSqliteData("SELECT * FROM " + dbHelper.TABLE_USER + " WHERE " + dbHelper.COL_USERNAME + "='" + editUsername.getText() + "'");
            if (editUsername.getText().toString().trim().length() == 0 || editPassword.getText().toString().trim().length() == 0) {
                showMessage("MISSING", "PLEASE FILL OUT THE FORM");
                sleep(2000);
                return;
            } else if (c.moveToFirst()) {
                String strUsername = c.getString(0);
                String strPassword = c.getString(1);
                if ((getUsername.equals(strUsername)) && (getPassword.equals(strPassword))) {

                    //to stay logged in
                    editor.putString("username",editUsername.getText().toString());
                    editor.commit();

                    showMessage("SUCCESS", "WELCOME TO PiaKNOWS!");
                    editUsername.setText("");
                    editPassword.setText("");
                    final Thread myThread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(2000);
                                Intent intent = new Intent(getApplicationContext(), user.class);
                                startActivity(intent);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    myThread.start();
                } else {
                    showMessage("FAILED", "WRONG USERNAME OR PASSWORD");
                    editUsername.setText("");
                    editPassword.setText("");
                }
            } else {
                showMessage("FAILED", "NO USERNAME FOUND");
                editUsername.setText("");
                editPassword.setText("");
            }
        }
    }

    private void sleep(int i) {
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

