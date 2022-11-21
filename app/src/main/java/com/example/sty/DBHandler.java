package com.example.sty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "userprofile";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_NAME = "myclients";
    // below variable is for our course name column
    private static final String NAME_COL = "name";

    String usrname;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + NAME_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //Fetching
    public String feactch(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        while (cursor.moveToNext()){
           usrname=cursor.getString(0);
        }
        return usrname;
    }

    public void addnewuser(String userName) {
        // on below line we are creating a variable for our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values along with its key and value pair.
        values.put(NAME_COL,userName);
        db.insert(TABLE_NAME, null,values);
        // at last we are closing our database after adding database.
        db.close();
    }
}
