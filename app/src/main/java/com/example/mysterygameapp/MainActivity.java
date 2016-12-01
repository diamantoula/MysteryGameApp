package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button) findViewById(R.id.loginMain);
        loginBtn.setOnClickListener(this);
        Button registerBtn = (Button) findViewById(R.id.registerMain);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.loginMain:
                startActivity(new Intent(MainActivity.this, Login.class));
                //startActivity(new Intent(MainActivity.this, MyAsyncTask.class));
                break;

            case R.id.registerMain:
                startActivity(new Intent(MainActivity.this, Register.class));
                break;
        }
    }
}
