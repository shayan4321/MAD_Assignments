package com.shayan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView register;
    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerHERE(View view) {

        Intent reg=new Intent(this,RegisterActivity.class);
        startActivity(reg);
    }

    public void towardsHome(View view) {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        if (username.getText().toString().equals(""))
        {
            username.setError("Please Enter User Name");
        }
        else if (password.getText().toString().equals(""))
        {
            password.setError("Please Enter Password");
        }
        else
        {

            Intent home=new Intent(this,HomeActivity.class);
        startActivity(home);}
    }
}
