package com.example.aeks;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WordsDatabase extends SQLiteOpenHelper {

    public static final String WORDS_TABLE = "words";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EN_WORD = "en_word";

    private Context context;
    private String databaseName;
    private  static String Databasepath;

    public WordsDatabase(@Nullable Context context) {
        super(context, WORDS_TABLE, null, 1);
       // this.context=context;
       // ContextWrapper cw = new ContextWrapper(context);
      //  Databasepath = cw.getFilesDir().getAbsolutePath() + "/databases/";
      //  databaseName="Words";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + WORDS_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EN_WORD + " TEXT" + ")");

    }

    public void addenword(String en_word) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_EN_WORD,en_word);
        sqLiteDatabase.insert(WORDS_TABLE,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WORDS_TABLE);
        onCreate(sqLiteDatabase);

    }

    public String generateWord(int pID) {

        String query = "SELECT COLUMN_EN_WORD FROM " + WORDS_TABLE + " WHERE " + COLUMN_ID + " = '" + pID + "'" ;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getString(0);

    }
/*
    public void DbExists() {
        SQLiteDatabase sqLiteDatabase=null;
        try {
            sqLiteDatabase = SQLiteDatabase.openDatabase(Databasepath, null, 0);

        }
        catch (Exception e){

        }
        if (sqLiteDatabase!=null) {

        }
        else {
            Getdatabase();

        }
    }

    public void Getdatabase() {
        this.getReadableDatabase();
        try {
            InputStream inputStream =context.getAssets().open(databaseName);
            OutputStream outputStream=new FileOutputStream(Databasepath + databaseName);

            byte[] buffer=new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0) {
                outputStream.write(buffer,0,length);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

 */


}
