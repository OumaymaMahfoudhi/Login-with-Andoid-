package com.example.login;
import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private EditText Name ;
    private EditText Password ;
    private TextView info ;
    private Button login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.button);
        info = (TextView) findViewById(R.id.tvinfo);
        info.setText("No of attemps remaining:5");



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString()  );

            }
        });


    }
    private void validate(String userName, String userPassword) {
        if((userName.equals("hi")) && (userPassword.equals("hi"))){
            Intent i = new Intent (MainActivity.this, SecondActivity.class);
            startActivity(i);
        } else{
            counter--;
            info.setText("No of attemps remaining:" + String.valueOf(counter));


            if (counter == 0) {
                login.setEnabled(false);
            }
        }
    }
}