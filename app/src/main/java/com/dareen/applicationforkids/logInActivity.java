package com.dareen.applicationforkids;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class logInActivity extends AppCompatActivity {

    EditText username , password ;
    Button login ,register ;
    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);

        username = findViewById(R.id.country);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);
        register = findViewById(R.id.registerbtn);

        preferences = getSharedPreferences("Userinfo",0);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usenameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registedusername = preferences.getString("username", "");
                String registedpassword= preferences.getString("password","");


                if(usenameValue.equals(registedusername)&&passwordValue.equals(registedpassword)){
                    Intent intent = new Intent(logInActivity.this,MainActivity.class);
                    startActivity(intent);
                } else if (usenameValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText(logInActivity.this, "A field missing ..!", Toast.LENGTH_SHORT).show();

                } else if (usenameValue.isEmpty() & passwordValue.isEmpty()) {
                    Toast.makeText(logInActivity.this, "write your username and the password ", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(logInActivity.this, "You don't Have account", Toast.LENGTH_SHORT).show();
                }
            }


        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(logInActivity.this, RegestrationActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}