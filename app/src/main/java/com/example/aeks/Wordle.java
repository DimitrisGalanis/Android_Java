package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        String test = "ABCDE";

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
                    if ( letterLength >= 1 )
                    {
                        array[finalI + 1].requestFocusFromTouch();
                        array[finalI + 1].setFocusableInTouchMode(true);

                        if (finalI>=5 && finalI%5==0)
                        {
                            testingLetters(finalI, array, test);
                        }
                    }
                }
            });
        }
    }


    // Helper Function for testing letters
    private void testingLetters(int index , EditText[] v , String test){
        for ( int j = 0 ; j<test.length() ; ++j)
        {
            String temp = Character.toString(test.charAt(j));
            for (int i = 0; i < 5 ; ++i)
            {
                if ( v[index + i - 4].getText().toString().equals(temp) && i!=j)
                {
                    v[index + i - 4].getBackground().setColorFilter(Color.rgb(214, 214, 32), PorterDuff.Mode.SRC_ATOP);
                } else if ( v[index + i - 4].getText().toString().equals(temp) && i==j)
                {
                    v[index + i - 4].getBackground().setColorFilter(Color.rgb(56, 120, 24), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }
    }
}