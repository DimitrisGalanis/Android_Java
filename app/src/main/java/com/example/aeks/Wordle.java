package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class Wordle extends AppCompatActivity {

    EditText Et11, Et12, Et13, Et14, Et15;
    EditText Et21, Et22, Et23, Et24, Et25;
    EditText Et31, Et32, Et33, Et34, Et35;
    EditText Et41, Et42, Et43, Et44, Et45;
    EditText Et51, Et52, Et53, Et54, Et55;
    EditText Et61, Et62, Et63, Et64, Et65;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordle);

        EditText[] array = new EditText[30];

        array[0] = Et11 = (EditText) findViewById(R.id.word1_1);
        array[1] = Et12 = (EditText) findViewById(R.id.word1_2);
        array[2] = Et13 = (EditText) findViewById(R.id.word1_3);
        array[3] = Et14 = (EditText) findViewById(R.id.word1_4);
        array[4] = Et15 = (EditText) findViewById(R.id.word1_5);

        array[5] = Et21 = (EditText) findViewById(R.id.word2_1);
        array[6] = Et22 = (EditText) findViewById(R.id.word2_2);
        array[7] = Et23 = (EditText) findViewById(R.id.word2_3);
        array[8] = Et24 = (EditText) findViewById(R.id.word2_4);
        array[9] = Et25 = (EditText) findViewById(R.id.word2_5);

        array[10] = Et31 = (EditText) findViewById(R.id.word3_1);
        array[11] = Et32 = (EditText) findViewById(R.id.word3_2);
        array[12] = Et33 = (EditText) findViewById(R.id.word3_3);
        array[13] = Et34 = (EditText) findViewById(R.id.word3_4);
        array[14] = Et35 = (EditText) findViewById(R.id.word3_5);

        array[15] = Et41 = (EditText) findViewById(R.id.word4_1);
        array[16] = Et42 = (EditText) findViewById(R.id.word4_2);
        array[17] = Et43 = (EditText) findViewById(R.id.word4_3);
        array[18] = Et44 = (EditText) findViewById(R.id.word4_4);
        array[19] = Et45 = (EditText) findViewById(R.id.word4_5);

        array[20] = Et51 = (EditText) findViewById(R.id.word5_1);
        array[21] = Et52 = (EditText) findViewById(R.id.word5_2);
        array[22] = Et53 = (EditText) findViewById(R.id.word5_3);
        array[23] = Et54 = (EditText) findViewById(R.id.word5_4);
        array[24] = Et55 = (EditText) findViewById(R.id.word5_5);

        array[25] = Et61 = (EditText) findViewById(R.id.word6_1);
        array[26] = Et62 = (EditText) findViewById(R.id.word6_2);
        array[27] = Et63 = (EditText) findViewById(R.id.word6_3);
        array[28] = Et64 = (EditText) findViewById(R.id.word6_4);
        array[29] = Et65 = (EditText) findViewById(R.id.word6_5);

        //Get Word from DB
        String test = "ABCDE";



        for (int i=0 ; i < 4 ; ++i)
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
                public void afterTextChanged(Editable editable) {
                    Integer letterLength = array[finalI].getText().length();
                    if ( letterLength >= 1) {
                        array[finalI+1].requestFocusFromTouch();
                        array[finalI+1].setFocusableInTouchMode(true);
                    }


//                    if (array[finalI].getText().toString().equals("A"))
//                    {
//                        array[finalI].getBackground().setColorFilter(Color.rgb(56, 120, 24), PorterDuff.Mode.SRC_ATOP);
//                    }
//
//                    if (array[finalI].getText().toString().equals("W"))
//                    {
//                        array[finalI].getBackground().setColorFilter(Color.rgb(214, 214, 32), PorterDuff.Mode.SRC_ATOP);
//                    }
                }
            });
        }






    }
}