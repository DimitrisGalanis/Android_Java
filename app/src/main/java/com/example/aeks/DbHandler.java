package com.example.aeks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PLAYER_TABLE = "Player";

    public DbHandler(@Nullable Context context) {
        super(context, PLAYER_TABLE + "Db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + PLAYER_TABLE + "(" + USERNAME + " TEXT primary key, " + PASSWORD + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PLAYER_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void CreateAccont(String username, String password) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(USERNAME,username);
        cv.put(PASSWORD,password);
        sqLiteDatabase.insert(PLAYER_TABLE,null,cv);
        sqLiteDatabase.close();

    }

    /*
    public Player loginUser(String username,String password) {

        String query = "SELECT * FROM " + PLAYER_TABLE + " WHERE " + USERNAME + " = '" + username + "'" ;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.getCount()<0) {

            return null;
        }
         query = "SELECT * FROM " + PLAYER_TABLE + " WHERE " + PASSWORD + " = '" + password + "'" ;

         cursor = sqLiteDatabase.rawQuery(query, null);
         if(cursor.getCount()<0){

             return null;
         }

         return new Player(username,password);


    }

     */

    public boolean findUser(String username) {

        String query = "SELECT * FROM " + PLAYER_TABLE + " WHERE " + USERNAME + " = '" + username + "'" ;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    public boolean checkPassword(String password) {

        String query = "SELECT * FROM " + PLAYER_TABLE + " WHERE " + PASSWORD + " = '" + password + "'" ;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount() > 0;
    }




}
