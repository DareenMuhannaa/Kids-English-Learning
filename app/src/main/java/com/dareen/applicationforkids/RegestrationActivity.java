package com.dareen.applicationforkids;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegestrationActivity extends AppCompatActivity {
EditText username ,password ,address ,phonenumber ,country ,age ;
Button signup , cancel ;
RadioButton female;
RadioGroup gender ;
SharedPreferences preferences ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regestration);
        username = findViewById(R.id.regusername);
        password =findViewById(R.id.regpassword);
        address= findViewById(R.id.address);
        phonenumber =findViewById(R.id.phonenum);
        country = findViewById(R.id.country);
        age=findViewById(R.id.age);

        signup=findViewById(R.id.signbtn);
        cancel=findViewById(R.id.cancelbtn);

        female=findViewById(R.id.female);
        gender = findViewById(R.id.gender);

        preferences = getSharedPreferences("Userinfo",0);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String addressValue = address.getText().toString();
                String phoneValue = phonenumber.getText().toString();
                String countryValue = country.getText().toString();
                String ageValue = age.getText().toString();

                //RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonI);
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedBtn.getText().toString();
                if (usernameValue.length() > 1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("address", addressValue);
                    editor.putString("phone", phoneValue);
                    editor.putString("country", countryValue);
                    editor.putString("age", ageValue);
                    editor.putString("gender", genderValue);
                    editor.apply();
                    Toast.makeText(RegestrationActivity.this, "Yser Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegestrationActivity.this, "Enter Value in the field ", Toast.LENGTH_SHORT).show();
                }
            }
        });




        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(RegestrationActivity.this, logInActivity.class);
                startActivity(mainIntent);
                finish();
            }


        });

    }

    public void emptyField(){
        username.setText("");
        password.setText("");
        age.setText("");
        country.setText("");
        address.setText("");
        phonenumber.setText("");
    }

}
