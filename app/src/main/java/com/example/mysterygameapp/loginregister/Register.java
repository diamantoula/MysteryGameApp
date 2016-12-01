package com.example.mysterygameapp.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mysterygameapp.CharacterOptions;
import com.example.mysterygameapp.R;

public class Register extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText etUsername = (EditText) findViewById(R.id.registerUsername);
        EditText etPassword = (EditText) findViewById(R.id.registerPassword);
        EditText etEmail = (EditText) findViewById(R.id.registerEmail);

        Button registerBtn = (Button) findViewById(R.id.registerSubmit);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(Register.this, CharacterOptions.class));

    }
}

