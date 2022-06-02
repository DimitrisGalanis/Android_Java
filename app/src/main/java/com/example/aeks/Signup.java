package com.example.aeks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        TextView confirm_password =(TextView) findViewById(R.id.confirm_password);
        MaterialButton signupBTN = (MaterialButton) findViewById(R.id.signup_btn);
        DBHelper db = new DBHelper(this, null , null , 1);

        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usrnm = username.getText().toString();
                String passwrd = password.getText().toString();
                String cnfpasswrd = confirm_password.getText().toString();

                if ( TextUtils.isEmpty(usrnm) || TextUtils.isEmpty(passwrd) || TextUtils.isEmpty(cnfpasswrd))
                {
                    Toast.makeText(Signup.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else
                {
                    if (passwrd.equals(cnfpasswrd))
                    {
                        if (db.checkUser(usrnm))
                        {
                            Toast.makeText(Signup.this, "This username already exists , try another one", Toast.LENGTH_SHORT).show();
                        } else
                        {
                            db.addUser(usrnm , passwrd);
                            Toast.makeText(Signup.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),Wordle.class);
                            startActivity(intent);
                        }
                    }
                    else
                    {
                        Toast.makeText(Signup.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });
    }

}