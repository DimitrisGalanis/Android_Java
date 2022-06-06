package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Wordle extends AppCompatActivity {
    int tries=0;
    EditText Et11, Et12, Et13, Et14, Et15;
    EditText Et21, Et22, Et23, Et24, Et25;
    EditText Et31, Et32, Et33, Et34, Et35;
    EditText Et41, Et42, Et43, Et44, Et45;
    EditText Et51, Et52, Et53, Et54, Et55;
    EditText Et61, Et62, Et63, Et64, Et65;
    static myWrapper wrap = new myWrapper();
    Dialog winDialog,looseDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordle);
        winDialog = new Dialog(this);
        looseDialog = new Dialog(this);

        EditText[] array = new EditText[31];
        array[0] = null;
        array[1] = Et11 =  findViewById(R.id.word1_1);
        array[2] = Et12 =  findViewById(R.id.word1_2);
        array[3] = Et13 =  findViewById(R.id.word1_3);
        array[4] = Et14 =  findViewById(R.id.word1_4);
        array[5] = Et15 =  findViewById(R.id.word1_5);

        array[6] = Et21 =  findViewById(R.id.word2_1);
        array[7] = Et22 =  findViewById(R.id.word2_2);
        array[8] = Et23 =  findViewById(R.id.word2_3);
        array[9] = Et24 =  findViewById(R.id.word2_4);
        array[10] = Et25 = findViewById(R.id.word2_5);

        array[11] = Et31 = findViewById(R.id.word3_1);
        array[12] = Et32 = findViewById(R.id.word3_2);
        array[13] = Et33 = findViewById(R.id.word3_3);
        array[14] = Et34 = findViewById(R.id.word3_4);
        array[15] = Et35 = findViewById(R.id.word3_5);

        array[16] = Et41 = findViewById(R.id.word4_1);
        array[17] = Et42 = findViewById(R.id.word4_2);
        array[18] = Et43 = findViewById(R.id.word4_3);
        array[19] = Et44 = findViewById(R.id.word4_4);
        array[20] = Et45 = findViewById(R.id.word4_5);

        array[21] = Et51 = findViewById(R.id.word5_1);
        array[22] = Et52 = findViewById(R.id.word5_2);
        array[23] = Et53 = findViewById(R.id.word5_3);
        array[24] = Et54 = findViewById(R.id.word5_4);
        array[25] = Et55 = findViewById(R.id.word5_5);

        array[26] = Et61 = findViewById(R.id.word6_1);
        array[27] = Et62 = findViewById(R.id.word6_2);
        array[28] = Et63 = findViewById(R.id.word6_3);
        array[29] = Et64 = findViewById(R.id.word6_4);
        array[30] = Et65 = findViewById(R.id.word6_5);


        //TODO Get Word from DB
        String test="ABCDE";



        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://random-word-api.herokuapp.com/word?length=5";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        wrap.setMywordle(response);
                        Toast.makeText(Wordle.this, wrap.getMywordle() , Toast.LENGTH_SHORT).show(); // Appears word
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Wordle.this, "Error Occurred" , Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        for (int i=1 ; i < array.length-5 ; ++i)
        {
            int finalI = i;
            array[i].addTextChangedListener(new TextWatcher()
            {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override // Sets focus on next Box
                public void afterTextChanged(Editable editable)
                {
                    int letterLength = array[finalI].getText().length();
                    if ( letterLength >= 1 && (finalI != array.length-6))
                    {
                        array[finalI + 1].requestFocusFromTouch();
                        array[finalI + 1].setFocusableInTouchMode(true);

                    }
                    if ((finalI>=5 && finalI%5==0))
                    {
                        ++tries;
                        testingLetters(finalI, array, wrap.getMywordle() , tries);
                    }
                }
            });
        }
    }


    // Helper Function for testing letters
    private void testingLetters(int index , EditText[] v , String test , int tries)
    {
        int count = 0;
        for (int i=0 ; i < 5 ; i++)
        {
            if ( test.contains(v[index +i - 4].getText().toString()) ) // checks if contains and turns yellow
                v[index +i - 4].getBackground().setColorFilter(Color.rgb(214, 214, 32), PorterDuff.Mode.SRC_ATOP);      // yellow


            String temp = Character.toString(test.charAt(i));  // character at i position
            if ( v[index + i - 4].getText().toString().equals(temp) )  // checks if its in right spot and turns green
            {
                v[index + i - 4].getBackground().setColorFilter(Color.rgb(56, 120, 24), PorterDuff.Mode.SRC_ATOP);      //  green
                ++count;
            }
        }
        if (count==5)
        {
            winDialog.setContentView(R.layout.costum_popup);
            winDialog.show();
            Button playAgain = (Button) winDialog.findViewById(R.id.ID_playBTN);
            TextView x = (TextView) winDialog.findViewById(R.id.finish);

            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    winDialog.dismiss();
                }
            });


            playAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    winDialog.dismiss();
                    finish();
                    redirectWordle();
                }
            });
        }

        if (tries==5)
        {
            looseDialog.setContentView(R.layout.fail_popup);
            looseDialog.show();
            Button playAgain_L = (Button) looseDialog.findViewById(R.id.ID_playBTN_L);
            TextView x_L = (TextView) looseDialog.findViewById(R.id.finish_L);

            x_L.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    looseDialog.dismiss();
                }
            });


            playAgain_L.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    looseDialog.dismiss();
                    finish();
                    redirectWordle();
                }
            });


            Et61.setText(Character.toString(wrap.getMywordle().charAt(0)));
            Et61.getBackground().setColorFilter(Color.rgb(229, 50, 50), PorterDuff.Mode.SRC_ATOP);
            Et62.setText(Character.toString(wrap.getMywordle().charAt(1)));
            Et62.getBackground().setColorFilter(Color.rgb(229, 50, 50), PorterDuff.Mode.SRC_ATOP);
            Et63.setText(Character.toString(wrap.getMywordle().charAt(2)));
            Et63.getBackground().setColorFilter(Color.rgb(229, 50, 50), PorterDuff.Mode.SRC_ATOP);
            Et64.setText(Character.toString(wrap.getMywordle().charAt(3)));
            Et64.getBackground().setColorFilter(Color.rgb(229, 50, 50), PorterDuff.Mode.SRC_ATOP);
            Et65.setText(Character.toString(wrap.getMywordle().charAt(4)));
            Et65.getBackground().setColorFilter(Color.rgb(229, 50, 50), PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void redirectWordle(){
        Intent intent = new Intent(this,Wordle.class);
        startActivity(intent);
    }
}