package com.example.aeks;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        MaterialButton loginBTN = (MaterialButton) findViewById(R.id.login_BTN);


        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( keyCode == KeyEvent.KEYCODE_ENTER  && event.getAction() == KeyEvent.ACTION_DOWN)
                {
                        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                        {
                            Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL !!!", Toast.LENGTH_SHORT).show();
                            redirect(v);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                        }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCredential(username,password))
                {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL !!!", Toast.LENGTH_SHORT).show();
                    redirect(v);
                }
                else
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void redirect(View v){

       Intent intent = new Intent(this,Wordle.class);
       startActivity(intent);
    }


    private boolean checkCredential(TextView username , TextView password)
    {
       return true;
//       return (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"));
    }

}