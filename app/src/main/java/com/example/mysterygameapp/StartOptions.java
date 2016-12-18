package com.example.mysterygameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mysterygameapp.singletons.SingletonData;

public class StartOptions extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_options);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button resumeBtn = (Button) findViewById(R.id.resumeBtn);

        startBtn.setOnClickListener(this);
        resumeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startBtn:
                startActivity(new Intent(StartOptions.this, Prologue.class));
                break;

            case R.id.resumeBtn:
                startActivity(new Intent(StartOptions.this, MapDemoActivity.class));
                break;
        }

    }

}
