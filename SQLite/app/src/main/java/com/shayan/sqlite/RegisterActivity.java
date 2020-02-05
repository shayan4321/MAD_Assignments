package com.shayan.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,password,phone;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void loginActivity(View view) {

        String usernameText=username.getText().toString().trim();
        String emailText=email.getText().toString().trim();
        String passText=password.getText().toString().trim();
        String phoneText=phone.getText().toString().trim();

        if (emailText.length()>1 && passText.length()>1)
        {
            databaseHelper=new DatabaseHelper(this);

            ContentValues contentValues=new ContentValues();
            contentValues.put("username",usernameText);
            contentValues.put("email",emailText);
            contentValues.put("password",passText);
            contentValues.put("phone",phoneText);

            databaseHelper.insertUser(contentValues);

            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Successfully Registered",Toast.LENGTH_SHORT).show();

        }
    }

    public void navigateToLogin(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
