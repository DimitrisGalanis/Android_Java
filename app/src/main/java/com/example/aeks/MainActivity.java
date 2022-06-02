package com.example.aeks;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
        TextView signup = (TextView) findViewById(R.id.sign_up);
        DBHelper db = new DBHelper(this, null , null , 1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect_signUp();
            }
        });


        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( keyCode == KeyEvent.KEYCODE_ENTER  && event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if(checkCredential(username,password,db))
                    {
                        redirectWordle();
                        return true;
                    }
                }
                return false;
            }
        });


        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCredential(username,password,db))
                    redirectWordle();
                else
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void redirectWordle(){
       Intent intent = new Intent(this,Wordle.class);
       startActivity(intent);
    }

    private void redirect_signUp (){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }


    private boolean checkCredential(TextView username , TextView password, DBHelper db)
    {
      String username_string = username.getText().toString().trim();
      String password_string = password.getText().toString();
      boolean flag = false;
      if (TextUtils.isEmpty(username_string) || TextUtils.isEmpty(password_string))
      {
          Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
      } else
      {
          if (db.findUser(username_string)==null)
          {
              Toast.makeText(MainActivity.this, "This user doesn't exist", Toast.LENGTH_SHORT).show();
          } else if (!db.findUser(username_string).getPassword().equals(password_string)){
              Toast.makeText(MainActivity.this, "Wrong Password , try again", Toast.LENGTH_SHORT).show();
          } else
          {
              Toast.makeText(MainActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();
              flag = true;
          }
      }
      return flag;
    }

}