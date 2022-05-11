package com.example.aeks;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    Λειτουργια/ onClick μεθοδος του κουμπιου PLAY, μεσω αυτου γίνεται μετάβαση στο activity με τις κάρτες
    για επιλογή παιχνιδιού
     */
    public void playbutton(View view) {

        Intent intent= new Intent(this,Cardlist.class);
        startActivity(intent);
    }


    /*
    Λειτουργια/ onClick μέθοδος του κουμπιου stats για προβολή των στατιστικών του χρήστη
     */
    public void statsButton(View view) {
    }

    public void AccountButton(View view) {

        Intent it = new Intent(this,Signin.class);
        startActivity(it);
    }
}