package com.example.mysterygameapp.loginregister;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysterygameapp.CharacterOptions;
import com.example.mysterygameapp.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername;
    EditText etPassword;
    EditText etEmail;

    String email, username, password;

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

        startActivity(new Intent(Register.this, CharacterOptions.class));

    }

}

