package com.shayan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText userName;
    EditText email;
    EditText password;
    EditText mblnumber;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void towardsLogin(View view) {

        userName = findViewById(R.id.UserName);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        mblnumber = findViewById(R.id.Mblnumber);
        signup = findViewById(R.id.signup);
        if (userName.getText().toString().equalsIgnoreCase(""))
        {
            userName.setError("Please Enter User Name");
        }
        else if (email.getText().toString().equalsIgnoreCase(""))
        {
            email.setError("Please Enter Email");
        }

        else if ( password.getText().toString().trim().equalsIgnoreCase("")|| password.length()<5 || password.length()>8){
            password.setError("Please Length should be 5 to 8 character");

        }
        else if (mblnumber.getText().toString().equalsIgnoreCase(""))
        {
            mblnumber.setError("Please Enter Mobile Number");
        }
        else{
            Intent login=new Intent(this,LoginActivity.class);
            startActivity(login);
        }
    }
}
