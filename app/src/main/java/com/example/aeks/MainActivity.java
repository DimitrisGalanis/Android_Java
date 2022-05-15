package com.example.aeks;



import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


    }


    public void CreateAccount(View view) {
        DbHandler dbHandler = new DbHandler(this);
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        dbHandler.CreateAccont(Username,Password);

    }

    public void login(View view) {

        DbHandler dbHandler = new DbHandler(this);

        if (dbHandler.findUser(username.getText().toString())){
              if(dbHandler.checkPassword(password.getText().toString())) {
                  Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                  Intent it= new Intent(this,Menu.class);
                  startActivity(it);
                         }
              else {
                 Toast.makeText(MainActivity.this,"Wrong password",Toast.LENGTH_LONG).show();


              }
        }
        else
        {
            Toast.makeText(MainActivity.this,"Username doesnt exist",Toast.LENGTH_LONG).show();

        }





    }
}