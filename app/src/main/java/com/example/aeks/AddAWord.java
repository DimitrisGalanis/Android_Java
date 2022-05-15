package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAWord extends AppCompatActivity {

    EditText word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aword);
        word=findViewById(R.id.writtenWord);
    }

    public void addWord(View view) {

        WordsDatabase wordsDatabase = new WordsDatabase(this);
        Log.v("here2",Integer.toString(word.getText().toString().length()));
        if(word.getText().toString().length()!=5) {
            Toast.makeText(this,"Wrong number of letters",Toast.LENGTH_LONG).show();
        }
        else {
            wordsDatabase.addenword(word.getText().toString());
            Toast.makeText(this,"ADDED!",Toast.LENGTH_LONG).show();


        }

    }
}