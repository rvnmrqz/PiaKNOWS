package com.example.kantu.piaknows;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    Context con;

    long result;
    private static  final  int DATABASE_VERSION=13;
    private static  final String DATABASE_NAME= "dbpiaknows.db";

    //TBL_USER
    public static  final String TABLE_USER = "tbl_user";
    public static  final String COL_USERNAME="username";//LOCAL ID
    public static  final String COL_PASSWORD = "password";
    public static  final String COL_FNAME = "fname";
    public static final String COL_LNAME = "lname";
    public static  final String COL_AGE = "age";
    public static  final String COL_CONTACT_NO = "contactno";
    public static  final String COL_ADDRESS = "address";
    public static final String COL_SCORE1 ="score1";
    public static final String COL_SCORE2 ="score2";
    public static final String COL_SCORE3 ="score3";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL("CREATE TABLE "+TABLE_USER+"("+
                        COL_USERNAME+" TEXT PRIMARY KEY, "+
                        COL_PASSWORD+" TEXT, "+
                        COL_FNAME + " TEXT, "+
                        COL_LNAME + " TEXT, "+
                        COL_SCORE1 + " INTEGER, "+
                        COL_SCORE2 + " INTEGER, "+
                        COL_SCORE3 + " INTEGER, "+
                        COL_AGE+" TEXT, "+
                        COL_CONTACT_NO+ " TEXT, "+
                        COL_ADDRESS+" TEXT)");

            System.out.println("DATABASE HAS BEEN CREATED");
        }catch (Exception ee){
            Toast.makeText(con, "Error encountered in creating tables \n"+ee.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER+";");
        Log.wtf("DBHELPER","Old database is dropped");
        onCreate(db);
    }

    public long insertUser(String username, String password,  String fname, String lname, String age, String contact_no, String address) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME,username);
        contentValues.put(COL_PASSWORD,password);
        contentValues.put(COL_FNAME, fname);
        contentValues.put(COL_LNAME,lname);
        contentValues.put(COL_PASSWORD,password);
        contentValues.put(COL_SCORE1,0);
        contentValues.put(COL_SCORE2,0);
        contentValues.put(COL_SCORE3,0);
        contentValues.put(COL_AGE,age);
        contentValues.put(COL_CONTACT_NO,contact_no);
        contentValues.put(COL_ADDRESS, address);
        result =  db.insertOrThrow(TABLE_USER,null,contentValues);
        return result;
    }

    public Cursor getSqliteData(String qry){
        Cursor cursor=null;
        try {

            SQLiteDatabase db = getWritableDatabase();
            cursor = db.rawQuery(qry,null);
            // db.close();
            return cursor;
        }catch (Exception e){
            Log.wtf("getSQLiteData",e.getMessage());
            Toast.makeText(con, "An error encountered", Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    public void executeQuery(String query){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(query);
            db.close();
            Log.wtf("ExecuteThisQuery","A query has been executed");
        }catch (Exception ee){
            Log.wtf("executeThisQuery",ee.getMessage());
        }
    }

    public void removeTableData(String TABLE_NAME){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+";");
    }



    //DB MANAGER
    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }



    public void removeAllData(){
        Log.wtf("removeAllData","FUNCTION IS CALLED\n\n\n\n\n");

        // query to obtain the names of all tables in your database
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        List<String> tables = new ArrayList<>();

// iterate over the result set, adding every table name to a list
        while (c.moveToNext()) {
            tables.add(c.getString(0));
            Log.wtf("while","table name: "+c.getString(0));

        }

        Log.wtf("deleting","DELETING\n\n\n\n");
        for (String table : tables) {
            Log.wtf("inside for loop","table name: "+table);
            String DELETE_DATA = "DELETE FROM " + table+";";
            db.execSQL(DELETE_DATA);
        }
    }
}
