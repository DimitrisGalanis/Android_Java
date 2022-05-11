package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Cardlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardlist);
    }

    public void play(View view) {

        Toast toast = Toast.makeText(this," ",Toast.LENGTH_LONG);

        switch (view.getId()) {

            case R.id.cardView:
                toast.setText("first card");
                toast.show();


                break;


            case R.id.cardView2:
                toast.setText("second card");
                toast.show();

                break;


            case R.id.cardView3:
                toast.setText("third card");
                toast.show();


                break;
        }
    }
}