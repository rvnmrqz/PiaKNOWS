package com.example.kantu.piaknows;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText editUsername,editPassword,editConfirmpassword,editFirstname,editLastname,editAge,editContactnumber,editAddress;
    Button btnAccept,cancel;
    SQLiteDatabase db;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);

        editUsername=(EditText)findViewById(R.id.username);
        editPassword=(EditText)findViewById(R.id.password);
        editConfirmpassword=(EditText)findViewById(R.id.confirmpassword);
        editFirstname=(EditText)findViewById(R.id.name);
        editLastname=(EditText)findViewById(R.id.lastname);
        editAge=(EditText)findViewById(R.id.age);
        editContactnumber=(EditText)findViewById(R.id.number);
        editAddress=(EditText)findViewById(R.id.address);

        btnAccept=(Button)findViewById(R.id.register);

        cancel=(Button)findViewById(R.id.back);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wew = new Intent(Register.this, login.class);
                startActivity(wew);
            }
        });

        btnAccept.setOnClickListener(this);
        db=openOrCreateDatabase("userDB",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS userTBL(username VARCHAR,password VARCHAR,confirmpassword VARCHAR,firstname VARCHAR,lastname VARCHAR,age VARCHAR,contactnumber VARCHAR,address VARCHAR);");

    }


    public void onClick(View view)
    {
        if(view==btnAccept)
        {
            Cursor c= dbHelper.getSqliteData("SELECT * FROM "+dbHelper.TABLE_USER+" WHERE "+dbHelper.COL_USERNAME+"='"+editUsername.getText()+"'");
            Cursor a= dbHelper.getSqliteData("SELECT * FROM "+dbHelper.TABLE_USER+" WHERE "+dbHelper.COL_CONTACT_NO+"='"+editContactnumber.getText()+"'");
            String strPassword=editPassword.getText().toString();
            String strConfirmpassword=editConfirmpassword.getText().toString();
            if(editUsername.getText().toString().trim().length()==0||editPassword.getText().toString().trim().length()==0
                    |editConfirmpassword.getText().toString().trim().length()==0||editFirstname.getText().toString().trim().length()==0
                    ||editLastname.getText().toString().trim().length()==0||editAge.getText().toString().trim().length()==0||
                    editContactnumber.getText().toString().trim().length()==0||editAddress.getText().toString().trim().length()==0)
            {
                showMessage("FAILED","Please Fill up all the Forms!");
                return;
            }
            else if(c.moveToFirst())
            {
                showMessage("FAILED REGISTER","USERNAME WAS ALREADY TAKEN. PLEASE CHANGE");
                editUsername.setText("");
            }
            else if(a.moveToFirst())
            {
                showMessage("FAILED REGISTER","CONTACT NUMBER WAS ALREADY TAKEN. PLEASE CHANGE");
                editContactnumber.setText("");
            }
            else if(strPassword.equals(strConfirmpassword))
            {

                dbHelper.insertUser(editUsername.getText().toString(),
                        editPassword.getText().toString(),
                        editFirstname.getText().toString(),
                        editLastname.getText().toString(),
                        editAge.getText().toString(),
                        editContactnumber.getText().toString(),
                        editAddress.getText().toString());

                showMessage("SUCCESS","YOUR RECORD HAS BEEN ADDED!");

                final Thread myThread=new Thread()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            sleep(2000);
                            Intent intent=new Intent(getApplicationContext(),login.class);
                            startActivity(intent);
                            finish();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                myThread.start();

                editUsername.setText("");
                editPassword.setText("");
                editConfirmpassword.setText("");
                editFirstname.setText("");
                editLastname.setText("");
                editAge.setText("");
                editContactnumber.setText("");
                editAddress.setText("");
            }
            else
            {
            }
        }
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
