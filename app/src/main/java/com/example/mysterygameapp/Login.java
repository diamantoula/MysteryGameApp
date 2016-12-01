package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText etEmail;
    EditText etPassword;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.loginEmail);
        etPassword = (EditText) findViewById(R.id.loginPassword);

        loginBtn = (Button) findViewById(R.id.loginSubmit);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(Login.this, StartOptions.class));

    }
}
