package com.shayan.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signUpActivity(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void navigateToHome(View view)
    {
        String nameText=username.getText().toString();
        String pasText=password.getText().toString();
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.readUser(nameText,pasText);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
