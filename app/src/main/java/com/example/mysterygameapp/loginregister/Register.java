package com.example.mysterygameapp.loginregister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mysterygameapp.CharacterOptions;
import com.example.mysterygameapp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername;
    EditText etPassword;
    EditText etEmail;

    private String username;
    private String password;
    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.registerUsername);
        etPassword = (EditText) findViewById(R.id.registerPassword);
        etEmail = (EditText) findViewById(R.id.registerEmail);

        Button registerBtn = (Button) findViewById(R.id.registerSubmit);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        mail = etEmail.getText().toString();

        startActivity(new Intent(Register.this, CharacterOptions.class));

    }

}

